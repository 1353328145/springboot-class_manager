package com.jexing.classmanager.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * (Comment)实体类
 *
 * @since 2020-12-09 12:49:42
 */
public class Comment implements Serializable {

    private Integer id;

    private Integer fromId;

    private String content;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")

    private Date createTime;

    private List<CommentChild> children;

    private User fromUser;

    public User getFromUser() {
        return fromUser;
    }

    public void setFromUser(User fromUser) {
        this.fromUser = fromUser;
    }

    public List<CommentChild> getChildren() {
        return children;
    }

    public void setChildren(List<CommentChild> children) {
        this.children = children;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFromId() {
        return fromId;
    }

    public void setFromId(Integer fromId) {
        this.fromId = fromId;
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

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", fromId=" + fromId +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                ", children=" + children +
                ", fromUser=" + fromUser +
                '}';
    }
}
