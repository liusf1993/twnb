package com.lsf.twnb.entity;

import java.util.Date;

public class SignRecord {
    private Integer id;

    private String signType;

    private Date signDate;

    private Date signTime;

    private String signUser;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public Date getSignDate() {
        return signDate!=null? (Date) signDate.clone() :null;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate!=null? (Date) signDate.clone() :null;
    }

    public Date getSignTime() {
        return signTime!=null? (Date) signTime.clone() :null;
    }

    public void setSignTime(Date signTime) {
        this.signTime = signTime!=null? (Date) signTime.clone() :null;
    }

    public String getSignUser() {
        return signUser;
    }

    public void setSignUser(String signUser) {
        this.signUser = signUser;
    }
}