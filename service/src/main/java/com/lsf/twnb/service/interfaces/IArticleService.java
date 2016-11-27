package com.lsf.twnb.service.interfaces;

import com.lsf.twnb.entity.ArticleWithContent;

import java.util.List;

/**
 * Created by liusf on 8/27/16.
 */
public interface IArticleService {
     ArticleWithContent getLastArticle(String userid);

    void saveArticle(ArticleWithContent articleWithContent);

    List<ArticleWithContent> getRecentTwoArticle(String username);

    ArticleWithContent getLastArticle(String currentBlogId, String type);
}
