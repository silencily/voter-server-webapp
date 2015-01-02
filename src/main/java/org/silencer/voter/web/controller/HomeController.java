/* 
 * CopyRright (c) 2013, Minxin and/or its affiliates. All rights reserved.
 */
package org.silencer.voter.web.controller;

import org.silencer.voter.entity.UserEntity;
import org.silencer.voter.entity.VoteEntity;
import org.silencer.voter.service.UserService;
import org.silencer.voter.service.VoteService;
import org.silencer.voter.web.security.SecurityContextHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author gejb
 * @since 14-8-26
 */
@Controller
public class HomeController {

    @Autowired
    private VoteService voteService;

    @RequestMapping(value = "home")
    public String home(Model model) {
        UserEntity userEntity = SecurityContextHelper.obtainCurrentSecurityUser().getUserEntity();
        model.addAttribute("currentUser", userEntity);
        List<VoteEntity> votes = voteService.initLoadVoteByUserId(userEntity.getId());
        model.addAttribute("votes", votes);
        return "home";
    }

}
