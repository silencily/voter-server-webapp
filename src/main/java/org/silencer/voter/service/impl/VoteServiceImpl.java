/* 
 * CopyRright (c) 2013, Minxin and/or its affiliates. All rights reserved.
 */
package org.silencer.voter.service.impl;

import com.mongodb.DBObject;
import org.silencer.voter.entity.UserEntity;
import org.silencer.voter.entity.VoteEntity;
import org.silencer.voter.entity.VoterEntity;
import org.silencer.voter.repository.UserRepository;
import org.silencer.voter.repository.VoteRepository;
import org.silencer.voter.repository.VoterRepository;
import org.silencer.voter.service.VoteService;
import org.silencer.voter.utils.VoterConstants;
import org.silencer.voter.core.security.SecurityContextHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
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
    private UserRepository userRepository;


    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private MongoTemplate mongoTemplate;

    @Value("${system.pagesize.initload}")
    private int initLoadPageSize;

    @Override
    public List<VoteEntity> initLoadVoteByUserId(String userId) {

        Aggregation aggregationCount = Aggregation.newAggregation(Aggregation.match(Criteria.where("userId").is(userId)), Aggregation.group("voteId"),
                Aggregation.group().count().as("count"), Aggregation.project("count").andExclude("_id"));
        AggregationResults<DBObject> aggregationResultsCount = mongoTemplate.aggregate(aggregationCount, VoterEntity.class, DBObject.class);
        DBObject objCount = aggregationResultsCount.getUniqueMappedResult();
        Integer count = (Integer) objCount.get("count");

        Aggregation aggregation = Aggregation.newAggregation(Aggregation.match(Criteria.where("userId").is(userId)),
                Aggregation.group("voteId").max("createTime").as("lastCreateTime"),
                Aggregation.sort(Sort.Direction.DESC, "lastCreateTime"), Aggregation.limit(initLoadPageSize));

        AggregationResults<DBObject> aggregationResults = mongoTemplate.aggregate(aggregation, VoterEntity.class, DBObject.class);
        List<DBObject> voterEntities = aggregationResults.getMappedResults();
        List<VoteEntity> votes = new ArrayList<VoteEntity>();
        for (DBObject voterEntity : voterEntities) {
            votes.add(voteRepository.findOne(voterEntity.get("_id").toString()));
        }

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
        voterEntity.setUserId(voteEntity.getCreator().getId());
        voterEntity.setVoteId(voteEntity.getId());
        voterRepository.save(voterEntity);

        UserEntity userEntity = voteEntity.getCreator();
        userEntity.getVoteCounter().setVotes(userEntity.getVoteCounter().getVotes() + 1);
        userRepository.save(userEntity);
    }

    @Override
    public boolean checkStarredBy(String voteId, String userId) {
        Query query1 = new Query();
        query1.addCriteria(Criteria.where("vote").is(voteId)
                .and("userId").is(userId).and("type").is(VoterConstants.VOTER_TYPE_STARRED));
        boolean findOne = mongoTemplate.exists(query1, VoterEntity.class);
        return findOne;
    }

    @Override
    public void toggleStar(String voteId, String userId) {
        Query query1 = new Query();
        query1.addCriteria(Criteria.where("vote").is(voteId)
                .and("userId").is(userId).and("type").is(VoterConstants.VOTER_TYPE_STARRED));
        VoterEntity voterEntity = mongoTemplate.findOne(query1, VoterEntity.class);
        if (voterEntity == null) {
            //新增
            VoteEntity voteEntity = voteRepository.findOne(voteId);

            VoterEntity voterEntity1 = new VoterEntity();
            voterEntity1.setUserId(userId);
            voterEntity1.setVoteId(voteId);
            voterEntity1.setType(VoterConstants.VOTER_TYPE_STARRED);
            voterRepository.save(voterEntity1);

            voteEntity.setStarred(voteEntity.getStarred() + 1);
            voteRepository.save(voteEntity);
            UserEntity userEntity = userRepository.findOne(userId);
            userEntity.getVoteCounter().setStarred(userEntity.getVoteCounter().getStarred() + 1);
            userRepository.save(userEntity);
            int currentStarred = SecurityContextHelper.obtainCurrentSecurityUser().getUserEntity().getVoteCounter().getStarred();
            SecurityContextHelper.obtainCurrentSecurityUser().getUserEntity().getVoteCounter().setStarred(currentStarred + 1);
        } else {
            //删除
            voterRepository.delete(voterEntity);
            VoteEntity voteEntity = voteRepository.findOne(voteId);
            voteEntity.setStarred(voteEntity.getStarred() - 1);
            voteRepository.save(voteEntity);
            UserEntity userEntity = userRepository.findOne(userId);
            userEntity.getVoteCounter().setStarred(userEntity.getVoteCounter().getStarred() - 1);
            userRepository.save(userEntity);
            int currentStarred = SecurityContextHelper.obtainCurrentSecurityUser().getUserEntity().getVoteCounter().getStarred();
            SecurityContextHelper.obtainCurrentSecurityUser().getUserEntity().getVoteCounter().setStarred(currentStarred - 1);
        }
    }

    @Override
    public List<Integer> obtainVotedChoices(String voteId, String userId) {
        List<Integer> choiceNos = new ArrayList<Integer>();
        Query query1 = new Query();
        query1.addCriteria(Criteria.where("vote").is(voteId)
                .and("userId").is(userId).and("type").is(VoterConstants.VOTER_TYPE_VOTED));
        VoterEntity findOne = mongoTemplate.findOne(query1, VoterEntity.class);
        if (findOne != null) {
            choiceNos = findOne.getVotedChoices();
        }
        return choiceNos;
    }

    @Override
    public List<VoteEntity.Choice> voted(String voteId, Integer[] choices, String userId) {
        VoteEntity voteEntity = voteRepository.findOne(voteId);
        voteEntity.setVoted(voteEntity.getVoted() + 1);
        List<Integer> chosenList = Arrays.asList(choices);
        List<VoteEntity.Choice> choiceList = voteEntity.getChoices();
        int choiceVoted = 0;
        for (VoteEntity.Choice choice : choiceList) {
            Integer no = choice.getNo();
            if (chosenList.contains(no)) {
                choice.setVoted(choice.getVoted() + 1);
            }
            choiceVoted += choice.getVoted();
        }
        for (VoteEntity.Choice choice : choiceList) {
            choice.setRatio(choice.getVoted() / (choiceVoted * 1f));
        }
        voteRepository.save(voteEntity);
        UserEntity userEntity = userRepository.findOne(userId);
        userEntity.getVoteCounter().setVoted(userEntity.getVoteCounter().getVoted() + 1);
        userRepository.save(userEntity);
        int currentVoted = SecurityContextHelper.obtainCurrentSecurityUser().getUserEntity().getVoteCounter().getVoted();
        SecurityContextHelper.obtainCurrentSecurityUser().getUserEntity().getVoteCounter().setVoted(currentVoted + 1);

        VoterEntity voterEntity = new VoterEntity();
        voterEntity.setType(VoterConstants.VOTER_TYPE_VOTED);
        voterEntity.setUserId(userId);
        voterEntity.setVoteId(voteId);
        voterEntity.setVotedChoices(chosenList);
        voterRepository.save(voterEntity);
        return voteEntity.getChoices();
    }

    @Override
    public List<VoteEntity> discoverNewVotes(String userId) {
        Query query1 = new Query();
        query1.addCriteria(Criteria.where("userId").is(userId));
        List voteIds = mongoTemplate.getCollection("voter").distinct("vote.$id", query1.getQueryObject());

        Query query2 = new Query();
        query2.addCriteria(Criteria.where("_id").nin(voteIds));
        query2.with(new Sort(Sort.Direction.DESC, "createTime"));
        List<VoteEntity> votes = mongoTemplate.find(query2, VoteEntity.class);

        return votes;
    }

    @Override
    public List<VoteEntity> discoverHotVotes(String userId) {
        Query query1 = new Query();
        query1.addCriteria(Criteria.where("userId").is(userId));
        List voteIds = mongoTemplate.getCollection("voter").distinct("vote.$id", query1.getQueryObject());

        Query query2 = new Query();
        query2.addCriteria(Criteria.where("_id").nin(voteIds));
        query2.with(new Sort(Sort.Direction.DESC, "voted"));
        List<VoteEntity> votes = mongoTemplate.find(query2, VoteEntity.class);

        return votes;
    }

    @Override
    public List<VoteEntity> discoverStarredVotes(String userId) {
        Query query1 = new Query();
        query1.addCriteria(Criteria.where("userId").is(userId));
        List voteIds = mongoTemplate.getCollection("voter").distinct("vote.$id", query1.getQueryObject());

        Query query2 = new Query();
        query2.addCriteria(Criteria.where("_id").nin(voteIds));
        query2.with(new Sort(Sort.Direction.DESC, "starred"));
        List<VoteEntity> votes = mongoTemplate.find(query2, VoteEntity.class);

        return votes;
    }

    @Override
    public List<VoteEntity> queryMeVotes(String userId) {
        Query query1 = new Query();
        query1.addCriteria(Criteria.where("userId").is(userId).and("type").is(VoterConstants.VOTER_TYPE_CREATED));
        query1.with(new Sort(Sort.Direction.DESC, "createTime"));
        List<VoterEntity> voterEntities = mongoTemplate.find(query1, VoterEntity.class);
        List<VoteEntity> votes = new ArrayList<VoteEntity>();
        for (VoterEntity voterEntity : voterEntities) {
            votes.add(voteRepository.findOne(voterEntity.getVoteId()));
        }
        return votes;
    }

    @Override
    public List<VoteEntity> queryMeVotedVotes(String userId) {

        Query query1 = new Query();
        query1.addCriteria(Criteria.where("userId").is(userId).and("type").is(VoterConstants.VOTER_TYPE_VOTED));
        query1.with(new Sort(Sort.Direction.DESC, "createTime"));
        List<VoterEntity> voterEntities = mongoTemplate.find(query1, VoterEntity.class);
        List<VoteEntity> votes = new ArrayList<VoteEntity>();
        for (VoterEntity voterEntity : voterEntities) {
            votes.add(voteRepository.findOne(voterEntity.getVoteId()));
        }
        return votes;
    }

    @Override
    public List<VoteEntity> queryMeStarredVotes(String userId) {
        Query query1 = new Query();
        query1.addCriteria(Criteria.where("userId").is(userId).and("type").is(VoterConstants.VOTER_TYPE_STARRED));
        query1.with(new Sort(Sort.Direction.DESC, "createTime"));
        List<VoterEntity> voterEntities = mongoTemplate.find(query1, VoterEntity.class);
        List<VoteEntity> votes = new ArrayList<VoteEntity>();
        for (VoterEntity voterEntity : voterEntities) {
            votes.add(voteRepository.findOne(voterEntity.getVoteId()));
        }
        return votes;
    }
}
