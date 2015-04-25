/* 
 * CopyRright (c) 2014, org.silencer and/or its affiliates. All rights reserved.
 */
package org.silencer.voter.web.controller;

import org.silencer.voter.entity.UserEntity;
import org.silencer.voter.service.VoteService;
import org.silencer.voter.web.security.SecurityContextHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author gejb
 * @since 2015-03-22
 */
@Controller
public class MeController {
    @Autowired
    private VoteService voteService;
    @RequestMapping(value = "me")
    public String me(Model model) {
        UserEntity userEntity = SecurityContextHelper.obtainCurrentSecurityUser().getUserEntity();
        model.addAttribute("currentUser", userEntity);

        return "me";
    }
}
