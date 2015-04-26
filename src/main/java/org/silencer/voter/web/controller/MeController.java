/* 
 * CopyRright (c) 2014, org.silencer and/or its affiliates. All rights reserved.
 */
package org.silencer.voter.web.controller;

import org.silencer.voter.entity.UserEntity;
import org.silencer.voter.entity.VoteEntity;
import org.silencer.voter.service.VoteService;
import org.silencer.voter.web.model.VoteModel;
import org.silencer.voter.web.security.SecurityContextHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

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
        List<VoteEntity> voteEntities = voteService.queryMeVotes(userEntity.getId());
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
        model.addAttribute("currentUser", userEntity);
        model.addAttribute("votes", votes);
        model.addAttribute("active", "me");
        return "me";
    }

    @RequestMapping(value = "me/voted")
    public String voted(Model model) {
        UserEntity userEntity = SecurityContextHelper.obtainCurrentSecurityUser().getUserEntity();
        List<VoteEntity> voteEntities = voteService.queryMeVotedVotes(userEntity.getId());
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
            vote.setVotedBy(true);
            vote.setChoices(choiceModels);
            vote.setStarredBy(voteService.checkStarredBy(voteEntity.getId(), userEntity.getId()));
            votes.add(vote);
        }
        model.addAttribute("currentUser", userEntity);
        model.addAttribute("votes", votes);
        model.addAttribute("active", "voted");
        return "me";
    }

    @RequestMapping(value = "me/starred")
    public String starred(Model model) {
        UserEntity userEntity = SecurityContextHelper.obtainCurrentSecurityUser().getUserEntity();
        List<VoteEntity> voteEntities = voteService.queryMeStarredVotes(userEntity.getId());
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
            vote.setStarredBy(true);
            votes.add(vote);
        }
        model.addAttribute("currentUser", userEntity);
        model.addAttribute("votes", votes);
        model.addAttribute("active", "starred");
        return "me";
    }
}
