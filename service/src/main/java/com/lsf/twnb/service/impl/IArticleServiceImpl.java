package com.lsf.twnb.service.impl;

import com.lsf.twnb.dao.ArticleMapper;
import com.lsf.twnb.entity.ArticleWithContent;
import com.lsf.twnb.service.interfaces.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by liusf on 8/27/16.
 */
@Service
public class IArticleServiceImpl implements IArticleService {
    @Autowired
    ArticleMapper entityMapper;

    @Override
    public ArticleWithContent getLastArticle(String username) {
        return entityMapper.getLastArtile(username);
    }

    @Override
    public void saveArticle(ArticleWithContent articleWithContent) {
        entityMapper.insert(articleWithContent);
    }

    public List<ArticleWithContent> getRecentTwoArticle(String username) {
        return entityMapper.getRecentTwoArticle(username);
    }
    @Override
    public ArticleWithContent getLastArticle(String currentBlogId, String type){
        return  entityMapper.getNextArticle(currentBlogId,type);
    }
}
