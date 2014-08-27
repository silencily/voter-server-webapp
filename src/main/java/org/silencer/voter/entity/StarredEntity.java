/* 
 * CopyRright (c) 2014, org.silencer and/or its affiliates. All rights reserved.
 */
package org.silencer.voter.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @author gejb
 * @since 2014-08-25
 */
@Document(collection = "starred")
public class StarredEntity extends AbstractEntity{
    @Id
    private String id;
    @DBRef
    private UserEntity voter;
    @DBRef
    private VoteEntity vote;
    @CreatedDate
    private Date starredTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserEntity getVoter() {
        return voter;
    }

    public void setVoter(UserEntity voter) {
        this.voter = voter;
    }

    public VoteEntity getVote() {
        return vote;
    }

    public void setVote(VoteEntity vote) {
        this.vote = vote;
    }

    public Date getStarredTime() {
        return starredTime;
    }

    public void setStarredTime(Date starredTime) {
        this.starredTime = starredTime;
    }
}
