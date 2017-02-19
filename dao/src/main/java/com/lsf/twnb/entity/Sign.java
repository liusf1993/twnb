package com.lsf.twnb.entity;

import java.util.Date;

public class Sign {
    private Integer id;

    private Integer uid;

    private String username;

    private Date signTime;

    private Date signDate;

    private String signType;

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
        this.username = username;
    }

    public Date getSignTime() {
        return signTime!=null? (Date) signTime.clone() :null;
    }

    public void setSignTime(Date signTime) {
        this.signTime = signTime!=null? (Date) signTime.clone() :null;
    }

    public Date getSignDate() {
        if(signDate!=null){
            return (Date) signDate.clone();
        }else{
            return null;
        }
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate!=null? (Date) signDate.clone() :null;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }
}