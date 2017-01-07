package com.lsf.twnb.entity;

public class ArticleWithContent extends Article {
    private byte[] content;

    private byte[] comment;

    public byte[] getContent() {
        if(content!=null){
            return content.clone();
        }else{
            return null;
        }
    }

    public void setContent(byte[] content) {
        this.content = content!=null?content.clone():null;
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