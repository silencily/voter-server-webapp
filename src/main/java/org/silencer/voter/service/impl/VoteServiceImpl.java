/* 
 * CopyRright (c) 2013, Minxin and/or its affiliates. All rights reserved.
 */
package org.silencer.voter.service.impl;

import org.silencer.voter.entity.VoteEntity;
import org.silencer.voter.entity.VoterEntity;
import org.silencer.voter.repository.VoteRepository;
import org.silencer.voter.repository.VoterRepository;
import org.silencer.voter.service.VoteService;
import org.silencer.voter.utils.VoterConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gejb
 * @since 14-8-26
 */
@Service
public class VoteServiceImpl implements VoteService {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private VoteRepository voteRepository;
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private VoterRepository voterRepository;


    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private MongoTemplate mongoTemplate;

    @Value("${system.pagesize.initload}")
    private int initLoadPageSize;

    @Override
    public List<VoteEntity> initLoadVoteByUserId(String userId) {

        Query query1 = new Query();
        query1.addCriteria(Criteria.where("userId").is(userId));
        query1.fields().include("voteId");

        List<VoterEntity> voterEntities = mongoTemplate.find(query1, VoterEntity.class);
        List<String> voteIds = new ArrayList<String>();
        for (VoterEntity voterEntity : voterEntities) {
            voteIds.add(voterEntity.getVoteId());
        }
        Query query2 = new Query();
        query2.addCriteria(Criteria.where("_id").in(voteIds));
        query2.limit(initLoadPageSize).with(new Sort(Sort.Direction.DESC, "lastUpdateTime"));
        List<VoteEntity> votes = mongoTemplate.find(query2, VoteEntity.class);
        return votes;
    }

    @Override
    public void addVote(String title, boolean multi, String[] choices) {
        VoteEntity voteEntity = new VoteEntity();
        voteEntity.setTitle(title);
        voteEntity.setMulti(multi);
        List<VoteEntity.Choice> choiceList = new ArrayList<VoteEntity.Choice>();
        for (int i = 0; i < choices.length; i++) {
            VoteEntity.Choice choice = new VoteEntity.Choice();
            choice.setNo(i + 1);
            choice.setContent(choices[i]);
            choice.setVoted(0);
            choice.setRatio(0.00f);
            choiceList.add(choice);
        }
        voteEntity.setChoices(choiceList);
        voteRepository.save(voteEntity);

        VoterEntity voterEntity = new VoterEntity();
        voterEntity.setType(VoterConstants.VOTER_TYPE_CREATED);
        voterEntity.setVoteId(voteEntity.getId());
        voterEntity.setUserId(voteEntity.getCreator().getId());
        voterRepository.save(voterEntity);
    }

    @Override
    public boolean checkStarredBy(String voteId, String userId) {
        Query query1 = new Query();
        query1.addCriteria(Criteria.where("voteId").is(voteId)
                .and("userId").is(userId).and("type").is(VoterConstants.VOTER_TYPE_STARRED));
        boolean findOne = mongoTemplate.exists(query1, VoterEntity.class);
        return findOne;
    }
}
