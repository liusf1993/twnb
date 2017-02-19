package com.lsf.twnb.controller.blog;

import com.lsf.twnb.constants.SessionConstants;
import com.lsf.twnb.entity.User;
import com.lsf.twnb.service.interfaces.IArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import twnb.query.concrete.BlogPageQuery;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Controller for manager blog
 */
@Controller
@RequestMapping("/blog")
public class BlogController {
    private final String PREFIX="blog";
    private IArticleService articleService;

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    public BlogController(IArticleService articleService) {
        this.articleService = articleService;
    }
    @RequestMapping(value = "/getBlogList")
    public String getBlogList(HttpServletRequest request,HttpSession session,ModelMap map){
        String page=request.getParameter("page");
        User user= (User) session.getAttribute(SessionConstants.USER);
        BlogPageQuery blogPageQuery=new BlogPageQuery();
        blogPageQuery.setUserName(user.getUsername());
        blogPageQuery.setPageSize(20);
        blogPageQuery.setPageNo(2);
        BlogPageQuery articleList=articleService.queryArticleList(blogPageQuery);
        map.put("queryResult",articleList);
        logger.info(page);
        return PREFIX+"/blogList";
    }



}
