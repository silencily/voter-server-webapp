/* 
 * CopyRright (c) 2014, org.silencer and/or its affiliates. All rights reserved.
 */
package org.silencer.voter.web.model;

import org.silencer.voter.entity.VoteEntity;

import java.util.Date;
import java.util.List;

/**
 * @author gejb
 * @since 2015-01-03
 */
public class VoteModel {
    private String id;
    private String title;
    private Date createTime;
    private int voted = 0;
    private int starred = 0;
    private boolean multi;
    private List<ChoiceModel> choices;
    private String creatorName;

    private boolean starredBy;//是否被当前用户标记星

    private boolean votedBy;//是否被当前用户投过

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getVoted() {
        return voted;
    }

    public void setVoted(int voted) {
        this.voted = voted;
    }

    public int getStarred() {
        return starred;
    }

    public void setStarred(int starred) {
        this.starred = starred;
    }

    public boolean isMulti() {
        return multi;
    }

    public void setMulti(boolean multi) {
        this.multi = multi;
    }

    public List<ChoiceModel> getChoices() {
        return choices;
    }

    public void setChoices(List<ChoiceModel> choices) {
        this.choices = choices;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public boolean isStarredBy() {
        return starredBy;
    }

    public void setStarredBy(boolean starredBy) {
        this.starredBy = starredBy;
    }

    public boolean isVotedBy() {
        return votedBy;
    }

    public void setVotedBy(boolean votedBy) {
        this.votedBy = votedBy;
    }

    public static class ChoiceModel{
        private int no;
        private String content;
        private int voted;
        private float ratio;

        private boolean votedBy;//是否被当前用户投过

        public int getNo() {
            return no;
        }

        public void setNo(int no) {
            this.no = no;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getVoted() {
            return voted;
        }

        public void setVoted(int voted) {
            this.voted = voted;
        }

        public float getRatio() {
            return ratio;
        }

        public void setRatio(float ratio) {
            this.ratio = ratio;
        }

        public boolean isVotedBy() {
            return votedBy;
        }

        public void setVotedBy(boolean votedBy) {
            this.votedBy = votedBy;
        }
    }
}
