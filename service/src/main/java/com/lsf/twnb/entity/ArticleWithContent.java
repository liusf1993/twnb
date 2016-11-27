package com.lsf.twnb.entity;

public class ArticleWithContent extends Article {
    private byte[] content;

    private byte[] comment;

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public byte[] getComment() {
        return comment;
    }

    public void setComment(byte[] comment) {
        this.comment = comment;
    }
}