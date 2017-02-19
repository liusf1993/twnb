package com.lsf.twnb.service.interfaces;

import com.lsf.twnb.entity.ArticleWithContent;
import com.lsf.twnb.entity.User;
import twnb.query.concrete.BlogPageQuery;

import java.util.List;

/**
 * Created by liusf on 8/27/16.
 */
public interface IArticleService {
     ArticleWithContent getLastArticle(String userid);

    void saveArticle(ArticleWithContent articleWithContent);

    List<ArticleWithContent> getRecentTwoArticle(String username);

    ArticleWithContent getLastArticle(String currentBlogId, String type);

    ArticleWithContent getRecentArticle();

    ArticleWithContent getArticleByUser(User user, String currentBlogId, String type);

    BlogPageQuery queryArticleList(BlogPageQuery blogPageQuery);
}
