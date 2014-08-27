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
@Document(collection = "notification")
public class NotificationEntity extends AbstractEntity{
    @Id
    private String id;
    @DBRef
    private UserEntity to;
    private Integer type;
    @CreatedDate
    private Date notiTime;
    private boolean readed;
    private String content;
    private boolean deleted;
    private Date delTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserEntity getTo() {
        return to;
    }

    public void setTo(UserEntity to) {
        this.to = to;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getNotiTime() {
        return notiTime;
    }

    public void setNotiTime(Date notiTime) {
        this.notiTime = notiTime;
    }

    public boolean isReaded() {
        return readed;
    }

    public void setReaded(boolean readed) {
        this.readed = readed;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Date getDelTime() {
        return delTime;
    }

    public void setDelTime(Date delTime) {
        this.delTime = delTime;
    }
}
