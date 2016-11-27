package com.lsf.twnb.entity;

import java.util.Date;

public class Signrecord {
    private Integer id;

    private String twnbType;

    private Date twnbDate;

    private Date twnbTime;

    private String twnbUser;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String gettwnbType() {
        return twnbType;
    }

    public void settwnbType(String twnbType) {
        this.twnbType = twnbType == null ? null : twnbType.trim();
    }

    public Date gettwnbDate() {
        return twnbDate;
    }

    public void settwnbDate(Date twnbDate) {
        this.twnbDate = twnbDate;
    }

    public Date gettwnbTime() {
        return twnbTime;
    }

    public void settwnbTime(Date twnbTime) {
        this.twnbTime = twnbTime;
    }

    public String gettwnbUser() {
        return twnbUser;
    }

    public void settwnbUser(String twnbUser) {
        this.twnbUser = twnbUser == null ? null : twnbUser.trim();
    }
}