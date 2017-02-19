package com.lsf.twnb.entity;

import java.util.Date;

public class Article {
    private Integer id;

    private String title;

    private String author;

    private Date publishdate;

    private String keyWorkd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public Date getPublishdate() {
        if(publishdate!=null){
            return (Date) publishdate.clone();
        }else{
            return null;
        }

    }

    public void setPublishdate(Date publishdate) {
        this.publishdate = publishdate!=null? (Date) publishdate.clone() :null;
    }

    public String getKeyWorkd() {
        return keyWorkd;
    }

    public void setKeyWorkd(String keyWorkd) {
        this.keyWorkd = keyWorkd;
    }
}