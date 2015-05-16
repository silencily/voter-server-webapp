/* 
 * CopyRright (c) 2013, Minxin and/or its affiliates. All rights reserved.
 */
package org.silencer.voter.web.controller;

import org.silencer.voter.core.AbstractControllerSupport;
import org.silencer.voter.core.Pagination;
import org.silencer.voter.core.WebContextHolder;
import org.silencer.voter.entity.UserEntity;
import org.silencer.voter.entity.VoteEntity;
import org.silencer.voter.service.VoteService;
import org.silencer.voter.web.model.VoteModel;
import org.silencer.voter.core.security.SecurityContextHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gejb
 * @since 14-8-26
 */
@Controller
public class HomeController extends AbstractControllerSupport {

    @Autowired
    private VoteService voteService;

    @RequestMapping(value = {"home", "home/index/*"}, method = RequestMethod.GET)
    public String home(Model model) {
        UserEntity userEntity = obtainCurrentUser();
        model.addAttribute("currentUser", userEntity);
        List<VoteEntity> voteEntities = voteService.queryHomeVotes(userEntity.getId());
        List<VoteModel> votes = new ArrayList<VoteModel>();
        for (VoteEntity voteEntity : voteEntities) {
            VoteModel vote = new VoteModel();
            vote.setId(voteEntity.getId());
            vote.setCreateTime(voteEntity.getCreateTime());
            vote.setCreatorName(voteEntity.getCreator().getUsername());
            vote.setMulti(voteEntity.isMulti());
            vote.setStarred(voteEntity.getStarred());
            vote.setTitle(voteEntity.getTitle());
            vote.setVoted(voteEntity.getVoted());
            List<Integer> votedChoices = voteService.obtainVotedChoices(voteEntity.getId(), userEntity.getId());
            List<VoteModel.ChoiceModel> choiceModels = new ArrayList<VoteModel.ChoiceModel>();
            for (VoteEntity.Choice choice : voteEntity.getChoices()) {
                VoteModel.ChoiceModel choiceModel = new VoteModel.ChoiceModel();
                choiceModel.setNo(choice.getNo());
                choiceModel.setContent(choice.getContent());
                choiceModel.setRatio(choice.getRatio());
                choiceModel.setVoted(choice.getVoted());
                choiceModel.setVotedBy(votedChoices.contains(choice.getNo()));
                choiceModels.add(choiceModel);
            }
            vote.setVotedBy(votedChoices.size() > 0);
            vote.setChoices(choiceModels);
            vote.setStarredBy(voteService.checkStarredBy(voteEntity.getId(), userEntity.getId()));
            votes.add(vote);
        }
        model.addAttribute("votes", votes);
        return "home";
    }
    @ResponseBody
    @RequestMapping(value = "home/index/*",method = RequestMethod.POST)
    public String home(){
        return "hello world";
    }


}
