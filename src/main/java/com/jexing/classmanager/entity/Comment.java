package com.jexing.classmanager.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (Comment)实体类
 *
 * @since 2020-12-09 12:49:42
 */
public class Comment implements Serializable {
    private static final long serialVersionUID = -36977061519211237L;

    private Integer id;

    private Integer nid;

    private Integer fromId;

    private String content;

    private Date createTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
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
                ", nid=" + nid +
                ", fromId=" + fromId +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}