package com.lsf.twnb.entity;

import java.util.Date;

public class Sign {
    private Integer id;

    private Integer uid;

    private String username;

    private Date twnbTime;

    private Date twnbDate;

    private String twnbType;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Date gettwnbTime() {
        return twnbTime;
    }

    public void settwnbTime(Date twnbTime) {
        this.twnbTime = twnbTime;
    }

    public Date gettwnbDate() {
        return twnbDate;
    }

    public void settwnbDate(Date twnbDate) {
        this.twnbDate = twnbDate;
    }

    public String gettwnbType() {
        return twnbType;
    }

    public void settwnbType(String twnbType) {
        this.twnbType = twnbType == null ? null : twnbType.trim();
    }
}