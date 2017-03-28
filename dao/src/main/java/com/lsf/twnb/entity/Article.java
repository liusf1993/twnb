package com.lsf.twnb.entity;

import java.io.Serializable;
import java.util.Date;

public class Article implements Serializable{
    private Integer id;

    private String title;

    private String author;

    private Date publishDate;

    private String keyWord;

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

    public Date getPublishDate() {
        if(publishDate !=null){
            return (Date) publishDate.clone();
        }else{
            return null;
        }

    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate !=null? (Date) publishDate.clone() :null;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }
}