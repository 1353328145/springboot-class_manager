package com.jexing.classmanager.entity;

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

    private Date createTime;


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

    @Override
    public String toString() {
        return "CommentChild{" +
                "id=" + id +
                ", cid=" + cid +
                ", fromId=" + fromId +
                ", toId=" + toId +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}