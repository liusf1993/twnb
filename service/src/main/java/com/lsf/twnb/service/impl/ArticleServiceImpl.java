package com.lsf.twnb.service.impl;

import com.lsf.twnb.constants.SystemConstants;
import com.lsf.twnb.dao.ArticleMapper;
import com.lsf.twnb.entity.ArticleWithContent;
import com.lsf.twnb.exception.TwnbException;
import com.lsf.twnb.service.interfaces.IArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lsf.twnb.query.concrete.BlogPageQuery;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Blog info
 */
@Service
public class ArticleServiceImpl implements IArticleService {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ArticleMapper entityMapper;

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
    public ArticleWithContent getLastArticle(String currentBlogId, String type) {
        return entityMapper.getNextArticle(currentBlogId, type);
    }

    @Override
    public ArticleWithContent getRecentArticle() {
        return entityMapper.getRecentArticle();
    }

    @Override
    public ArticleWithContent getArticleByUser(String username, Integer currentBlogId, String type) throws TwnbException {
        return entityMapper.getArticle(currentBlogId, username,type);
    }


    @Override
    public BlogPageQuery queryArticleList(BlogPageQuery blogPageQuery) {
        blogPageQuery.setItems(entityMapper.queryArticleList(blogPageQuery));
        return blogPageQuery;
    }

    /**
     * 根据ID获取文章
     * @param blogId 文章ID
     * @return
     */
    @Override
    public ArticleWithContent getArticleById(int blogId) throws TwnbException {
        ArticleWithContent articleWithContent=entityMapper.getArticleById(blogId);
        if(articleWithContent==null){
            return null;
        }
        try {
            articleWithContent.setStrContent(new String(articleWithContent.getContent(),
                    SystemConstants.DEFAULT_CHARACTER_SET));
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
            logger.error("系统不支持字符集{}",SystemConstants.DEFAULT_CHARACTER_SET);
            throw new TwnbException("系统不支持字符集{}",SystemConstants.DEFAULT_CHARACTER_SET);
        }
        return articleWithContent;
    }
}
