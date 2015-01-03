/* 
 * CopyRright (c) 2013, Minxin and/or its affiliates. All rights reserved.
 */
package org.silencer.voter.web.controller;

import org.silencer.voter.service.VoteService;
import org.silencer.voter.web.security.SecurityContextHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author gejb
 * @since 14-10-31
 */
@Controller
public class VoteController {

    @Autowired
    private VoteService voteService;

    @ResponseBody
    @RequestMapping(value = "vote", method = RequestMethod.POST)
    public String addVote(String title, boolean multi, @RequestParam(value = "choices[]") String[] choices) {
        voteService.addVote(title, multi, choices);
        return "Your Vote was posted!";
    }

    @ResponseBody
    @RequestMapping(value = "star", method = RequestMethod.POST)
    public String star(String voteId) {
        String userId = SecurityContextHelper.obtainCurrentSecurityUser().getUserEntity().getId();
        voteService.toggleStar(voteId, userId);
        return "";

    }

}
