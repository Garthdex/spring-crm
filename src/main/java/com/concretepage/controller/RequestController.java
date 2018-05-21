package com.concretepage.controller;

import com.concretepage.dto.RequestDTO;
import com.concretepage.entity.UserInfo;
import com.concretepage.service.IUserService;
import com.concretepage.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class RequestController {
    private static final String ROLE_USER  = "ROLE_USER";
    private static final String ROLE_ADMIN  = "ROLE_ADMIN";

    @Autowired
    private RequestService requestService;
    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/changeStatus", method = RequestMethod.POST)
    @ResponseBody
    public void changeRequestStatus(@RequestParam("requestStatus") String requestStatus, @RequestParam("requestId") Integer requestId) {
        requestService.updateStatusRequest(requestId, requestStatus);
    }

    @RequestMapping(value = "/requests")
    @ResponseBody
    public ModelAndView showRequestsAjax(ModelMap model, Authentication authentication) {
        List<RequestDTO> requests;
        if (authentication != null) {
            UserInfo user = userService.getDataByUserName(authentication.getName());
            if (user.getRole().equals(ROLE_USER)) {
                Integer userId = user.getUserId();
                requests = requestService.getRequestsDTOForUser(userId);
                model.addAttribute("requests", requests);
                return new ModelAndView( "/view/component/userRequests" );
            } else if (user.getRole().equals(ROLE_ADMIN)) {
                requests = requestService.getRequestsDTOForAdmin();
                model.addAttribute("requests", requests);
                return new ModelAndView( "/view/component/adminRequests" );
            }
        }
        return new ModelAndView("/view/page/access-denied");
    }
}
