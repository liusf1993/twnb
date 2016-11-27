package com.lsf.twnb.controller;

import com.lsf.twnb.constants.SystemConstants;
import com.lsf.twnb.entity.ArticleWithContent;
import com.lsf.twnb.entity.User;
import com.lsf.twnb.service.interfaces.IArticleService;
import com.lsf.twnb.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;


/**
 * Created by liusf13201 on 2015/11/12.
 */
@Controller
public class IndexController {
    @Autowired
    IArticleService articleService;

    @RequestMapping(value = {"/index",""})
    public String index(HttpServletRequest request, ModelMap map) throws UnsupportedEncodingException {
        String currentBlogId=request.getParameter("blogId");
        String type=request.getParameter("type");
        ArticleWithContent articleWithContent=null;
        if(StringUtil.isNotBlank(currentBlogId)){
            articleWithContent= articleService.getLastArticle(currentBlogId,type);
        }
        //get user by session,if user is null, do nothing;
        //else if user has login, get his/her recent two blog;
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            List<ArticleWithContent> recentTwoArticle=articleService.getRecentTwoArticle(user.getUsername());
            if(articleWithContent==null) {
                 articleWithContent = articleService.getLastArticle(user.getUsername());
            }
            map.put("article", articleWithContent);
            map.put("content", new String(articleWithContent.getContent(), SystemConstants.DEFAULT_CHARACTER_SET));
        }
        return "index";
    }

    @RequestMapping(value = "/testUE")
    public String testUE() {
        return "ueditor";
    }
}
