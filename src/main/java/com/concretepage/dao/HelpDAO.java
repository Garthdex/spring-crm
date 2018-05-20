package com.concretepage.dao;

import com.concretepage.entity.Help;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class HelpDAO {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    public Help saveHelp(Help help) {
        hibernateTemplate.save(help);
        return help;
    }
}
