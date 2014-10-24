/* 
 * CopyRright (c) 2013, Minxin and/or its affiliates. All rights reserved.
 */
package org.silencer.voter.service.impl;

import org.silencer.voter.entity.UserEntity;
import org.silencer.voter.entity.VoteEntity;
import org.silencer.voter.entity.VoterEntity;
import org.silencer.voter.repository.VoteRepository;
import org.silencer.voter.service.VoteService;
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
}
