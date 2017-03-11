package com.lsf.twnb.entity;

import com.lsf.twnb.constants.SystemConstants;

import java.io.UnsupportedEncodingException;

public class ArticleWithContent extends Article {
    private byte[] content;

    private byte[] comment;

    public String getStrContent() {
        return strContent;
    }

    public void setStrContent(String strContent) {
        this.strContent = strContent;
    }

    private String strContent;

    public byte[] getContent() {
        if(content!=null){
            return content.clone();
        }else{
            return null;
        }
    }

    public void setContent(byte[] content) {
        this.content = content!=null?content.clone():null;
        try {
            setStrContent(new String(content, SystemConstants.DEFAULT_CHARACTER_SET));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public byte[] getComment() {
        if(comment!=null) {
            return comment.clone();
        }else{
            return null;
        }
    }

    public void setComment(byte[] comment) {
        this.comment = comment!=null?comment.clone():null;
    }
}