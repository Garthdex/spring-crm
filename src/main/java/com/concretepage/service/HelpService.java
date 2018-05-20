package com.concretepage.service;

import com.concretepage.dao.HelpDAO;
import com.concretepage.entity.Help;
import org.springframework.beans.factory.annotation.Autowired;

public class HelpService {
    @Autowired
    private HelpDAO helpDAO;

    public Help saveHelp(Help help) {
        return helpDAO.saveHelp(help);
    }
}
