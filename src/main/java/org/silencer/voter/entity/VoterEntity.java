/* 
 * CopyRright (c) 2013, Minxin and/or its affiliates. All rights reserved.
 */
package org.silencer.voter.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

/**
 * @author gejb
 * @since 14-10-24
 */
@Document(collection = "voter")
public class VoterEntity extends AbstractEntity {
    @Id
    private String id;
    private String userId;
    private String voteId;
    private int type;
    @CreatedDate
    private Date createTime;

    private List<Integer> votedChoices;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getVoteId() {
        return voteId;
    }

    public void setVoteId(String voteId) {
        this.voteId = voteId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<Integer> getVotedChoices() {
        return votedChoices;
    }

    public void setVotedChoices(List<Integer> votedChoices) {
        this.votedChoices = votedChoices;
    }
}
