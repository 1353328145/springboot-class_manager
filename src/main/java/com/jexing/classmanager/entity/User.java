package com.jexing.classmanager.entity;

import java.io.Serializable;

/**
 * (User)实体类
 *
 * @since 2020-12-09 12:49:55
 */
public class User implements Serializable {
    private static final long serialVersionUID = 190036985338698650L;

    private Integer id;

    private String name;

    private String sno;

    private String password;

    private Integer stars;

    private String pn;

    private Object gender;

    private String email;

    private Integer rankId;

    private String photo;

    private Rank rank;

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public String getPn() {
        return pn;
    }

    public void setPn(String pn) {
        this.pn = pn;
    }

    public Object getGender() {
        return gender;
    }

    public void setGender(Object gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getRankId() {
        return rankId;
    }

    public void setRankId(Integer rankId) {
        this.rankId = rankId;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sno='" + sno + '\'' +
                ", password='" + password + '\'' +
                ", stars=" + stars +
                ", pn='" + pn + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", rankId=" + rankId +
                ", photo='" + photo + '\'' +
                ", rank=" + rank +
                '}';
    }
}