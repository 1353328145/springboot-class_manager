package com.jexing.classmanager.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (Notice)实体类
 *
 * @since 2020-12-09 12:49:54
 */
public class Notice implements Serializable {
    private static final long serialVersionUID = -48883128886111769L;

    private Integer id;

    private Integer uid;

    private String theme;

    private String content;

    private Date createTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
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
        return "Notice{" +
                "id=" + id +
                ", uid=" + uid +
                ", theme='" + theme + '\'' +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}