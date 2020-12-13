package com.jexing.classmanager.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (Comment)实体类
 *
 * @since 2020-12-09 12:49:42
 */
public class Comment implements Serializable {

    private Integer id;

    private Integer fromId;

    private String content;

    private Date createTime;


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
                '}';
    }
}