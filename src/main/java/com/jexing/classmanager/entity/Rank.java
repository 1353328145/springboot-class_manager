package com.jexing.classmanager.entity;

import java.io.Serializable;

/**
 * (Rank)实体类
 *
 * @since 2020-12-09 12:49:54
 */
public class Rank implements Serializable {
    private static final long serialVersionUID = -61171838874052536L;

    private Integer id;

    private Integer rank;

    private String info;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Rank{" +
                "id=" + id +
                ", rank=" + rank +
                ", info='" + info + '\'' +
                '}';
    }
}