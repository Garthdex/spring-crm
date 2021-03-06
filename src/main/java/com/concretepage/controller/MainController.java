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

import java.util.List;

@Controller
public class MainController {
    private static final String ROLE_USER  = "ROLE_USER";
    private static final String ROLE_ADMIN  = "ROLE_ADMIN";

    @Autowired
    private IUserService userService;
    @Autowired
    private RequestService requestService;

    @RequestMapping({"/", "/main"})
    public String getMainPage(ModelMap model, Authentication authentication) {
        List<RequestDTO> requests;
        if (authentication != null) {
            UserInfo user = userService.getDataByUserName(authentication.getName());
            if (user.getRole().equals(ROLE_USER)) {
                Integer userId = user.getUserId();
                requests = requestService.getRequestsDTOForUser(userId);
                model.addAttribute("requests", requests);
            } else if (user.getRole().equals(ROLE_ADMIN)) {
                requests = requestService.getRequestsDTOForAdmin();
                model.addAttribute("requests", requests);
            }
        }

        return "/view/page/main";
    }
}
