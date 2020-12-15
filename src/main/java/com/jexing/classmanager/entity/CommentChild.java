package com.jexing.classmanager.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * (CommentChild)实体类
 *
 * @since 2020-12-09 12:49:53
 */
public class CommentChild implements Serializable {
    private static final long serialVersionUID = 186482356950063895L;

    private Integer id;

    private Integer cid;

    private Integer fromId;

    private Integer toId;

    private String content;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")

    private Date createTime;

    private User fromUser;

    private User toUser;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getFromId() {
        return fromId;
    }

    public void setFromId(Integer fromId) {
        this.fromId = fromId;
    }

    public Integer getToId() {
        return toId;
    }

    public void setToId(Integer toId) {
        this.toId = toId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public User getFromUser() {
        return fromUser;
    }

    public void setFromUser(User fromUser) {
        this.fromUser = fromUser;
    }

    public User getToUser() {
        return toUser;
    }

    public void setToUser(User toUser) {
        this.toUser = toUser;
    }

    @Override
    public String toString() {
        return "CommentChild{" +
                "id=" + id +
                ", cid=" + cid +
                ", fromId=" + fromId +
                ", toId=" + toId +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                ", fromUser=" + fromUser +
                ", toUser=" + toUser +
                '}';
    }
}
