/* 
 * CopyRright (c) 2014, org.silencer and/or its affiliates. All rights reserved.
 */
package org.silencer.voter.web.controller;

import org.silencer.voter.entity.UserEntity;
import org.silencer.voter.entity.VoteEntity;
import org.silencer.voter.service.VoteService;
import org.silencer.voter.web.model.VoteModel;
import org.silencer.voter.core.security.SecurityContextHelper;
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
public class DiscoverController {
    @Autowired
    private VoteService voteService;

    @RequestMapping(value = "discover")
    public String discover(Model model) {
        //TODO:分页
        UserEntity userEntity = SecurityContextHelper.obtainCurrentSecurityUser().getUserEntity();
        List<VoteEntity> voteEntities = voteService.discoverNewVotes(userEntity.getId());
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
            List<VoteModel.ChoiceModel> choiceModels = new ArrayList<VoteModel.ChoiceModel>();
            for (VoteEntity.Choice choice : voteEntity.getChoices()) {
                VoteModel.ChoiceModel choiceModel = new VoteModel.ChoiceModel();
                choiceModel.setNo(choice.getNo());
                choiceModel.setContent(choice.getContent());
                choiceModel.setRatio(choice.getRatio());
                choiceModel.setVoted(choice.getVoted());
                choiceModel.setVotedBy(false);
                choiceModels.add(choiceModel);
            }
            vote.setVotedBy(false);
            vote.setChoices(choiceModels);
            vote.setStarredBy(false);
            votes.add(vote);
        }
        model.addAttribute("votes", votes);
        model.addAttribute("active","new");
        return "discover";
    }
    @RequestMapping(value = "discover/hot")
    public String hot(Model model) {
        //TODO:分页
        UserEntity userEntity = SecurityContextHelper.obtainCurrentSecurityUser().getUserEntity();
        List<VoteEntity> voteEntities = voteService.discoverHotVotes(userEntity.getId());
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
            List<VoteModel.ChoiceModel> choiceModels = new ArrayList<VoteModel.ChoiceModel>();
            for (VoteEntity.Choice choice : voteEntity.getChoices()) {
                VoteModel.ChoiceModel choiceModel = new VoteModel.ChoiceModel();
                choiceModel.setNo(choice.getNo());
                choiceModel.setContent(choice.getContent());
                choiceModel.setRatio(choice.getRatio());
                choiceModel.setVoted(choice.getVoted());
                choiceModel.setVotedBy(false);
                choiceModels.add(choiceModel);
            }
            vote.setVotedBy(false);
            vote.setChoices(choiceModels);
            vote.setStarredBy(false);
            votes.add(vote);
        }
        model.addAttribute("votes", votes);
        model.addAttribute("active","hot");
        return "discover";
    }
    @RequestMapping(value = "discover/starred")
    public String starred(Model model) {
        //TODO:分页
        UserEntity userEntity = SecurityContextHelper.obtainCurrentSecurityUser().getUserEntity();
        List<VoteEntity> voteEntities = voteService.discoverStarredVotes(userEntity.getId());
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
            List<VoteModel.ChoiceModel> choiceModels = new ArrayList<VoteModel.ChoiceModel>();
            for (VoteEntity.Choice choice : voteEntity.getChoices()) {
                VoteModel.ChoiceModel choiceModel = new VoteModel.ChoiceModel();
                choiceModel.setNo(choice.getNo());
                choiceModel.setContent(choice.getContent());
                choiceModel.setRatio(choice.getRatio());
                choiceModel.setVoted(choice.getVoted());
                choiceModel.setVotedBy(false);
                choiceModels.add(choiceModel);
            }
            vote.setVotedBy(false);
            vote.setChoices(choiceModels);
            vote.setStarredBy(false);
            votes.add(vote);
        }
        model.addAttribute("votes", votes);
        model.addAttribute("active","starred");
        return "discover";
    }

}
