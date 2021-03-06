package com.lsf.twnb.service.interfaces;

import com.lsf.twnb.entity.ArticleWithContent;
import com.lsf.twnb.entity.User;
import com.lsf.twnb.exception.TwnbException;
import com.lsf.twnb.query.concrete.BlogPageQuery;

import java.util.List;

/**
 *@author liusf
 *created on 8/27/16
 *class function
 */
public interface IArticleService {
     ArticleWithContent getLastArticle(String userid);

    void saveArticle(ArticleWithContent articleWithContent);

    List<ArticleWithContent> getRecentTwoArticle(String username);

    ArticleWithContent getLastArticle(String currentBlogId, String type);

    ArticleWithContent getRecentArticle();

    ArticleWithContent getArticleByUser(String username, Integer currentBlogId, String type)  throws TwnbException;

    BlogPageQuery queryArticleList(BlogPageQuery blogPageQuery);

    /**
     * 根据ID获取文章
     * @param blogId 文章ID
     * @return 文章
     */
    ArticleWithContent getArticleById(int blogId) throws TwnbException;

    void delete(int blogID);
}
