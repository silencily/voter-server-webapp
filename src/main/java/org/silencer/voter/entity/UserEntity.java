/* 
 * CopyRright (c) 2013, Minxin and/or its affiliates. All rights reserved.
 */
package org.silencer.voter.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @author gejb
 * @since 14-8-25
 */
@Document(collection = "user")
public class UserEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String username;
    private String email;
    private String password;
    private String fullname;
    private String smPhoto;
    private String lgPhoto;
    private String location;
    @CreatedDate
    private Date joinedDate;
    private boolean enabled;
    private VoteCounter voteCounter;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getSmPhoto() {
        return smPhoto;
    }

    public void setSmPhoto(String smPhoto) {
        this.smPhoto = smPhoto;
    }

    public String getLgPhoto() {
        return lgPhoto;
    }

    public void setLgPhoto(String lgPhoto) {
        this.lgPhoto = lgPhoto;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public VoteCounter getVoteCounter() {
        return voteCounter;
    }

    public void setVoteCounter(VoteCounter voteCounter) {
        this.voteCounter = voteCounter;
    }

    public class VoteCounter{
        private Integer votes;
        private Integer voted;
        private Integer starred;

        public Integer getVotes() {
            return votes;
        }

        public void setVotes(Integer votes) {
            this.votes = votes;
        }

        public Integer getVoted() {
            return voted;
        }

        public void setVoted(Integer voted) {
            this.voted = voted;
        }

        public Integer getStarred() {
            return starred;
        }

        public void setStarred(Integer starred) {
            this.starred = starred;
        }
    }
}
