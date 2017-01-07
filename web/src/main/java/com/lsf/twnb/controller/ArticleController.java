package com.lsf.twnb.controller;

import com.lsf.twnb.entity.ArticleWithContent;
import com.lsf.twnb.entity.User;
import com.lsf.twnb.service.interfaces.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by liusf on 8/27/16.
 */
@RequestMapping(value = "/article")
@Controller
public class ArticleController {
    @Autowired
    IArticleService articleService;

    @RequestMapping(value = "/postBlog", method = RequestMethod.GET)
    public String toPostArticle(HttpSession session) {
        return "article/postBlog";

    }

    @RequestMapping(value = "/postBlog", method = RequestMethod.POST)
    public String doPostArticle( HttpServletRequest request) throws Exception {
        User user= (User) request.getSession().getAttribute("user");
        String content=request.getParameter("blogContent");

        String keyWord=request.getParameter("keyWord");
        String title=request.getParameter("title");
        ArticleWithContent article=new ArticleWithContent();
        article.setTitle(title);
        article.setAuthor(user.getUsername());
        article.setTitle(title);
        article.setAuthor(user.getUsername());
        article.setKeyWorkd(keyWord);
        article.setContent(content.getBytes("utf8"));
        articleService.saveArticle(article);

        return "article/postBlog";

    }
}
