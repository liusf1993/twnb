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
        User user = (User) session.getAttribute("user");
        return "article/postBlog";

    }

    @RequestMapping(value = "/postBlog", method = RequestMethod.POST)
    public String doPostArticle( HttpServletRequest request) {
        User user= (User) request.getSession().getAttribute("user");
        String content=request.getParameter("blogContent");

        String keyWord=request.getParameter("keyWord");
        String title=request.getParameter("title");
        ArticleWithContent article=new ArticleWithContent();
        article.setTitle(title);
        article.setAuthor(user.getUsername());
        article.setTitle(title);
        article.setAuthor(user.getUsername());
        article.setContent(content.getBytes());
        articleService.saveArticle(article);

        return "article/postBlog";

    }
}
