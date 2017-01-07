package com.lsf.twnb.controller;

import com.lsf.twnb.constants.SystemConstants;
import com.lsf.twnb.entity.ArticleWithContent;
import com.lsf.twnb.entity.User;
import com.lsf.twnb.service.interfaces.IArticleService;
import com.lsf.twnb.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;


/**
 * Controller for homePage
 */
@Controller
public class IndexController {
    @Autowired
    public IndexController(IUserService userService, IArticleService articleService) {
        Assert.notNull(userService,"no implication found for userService");
        this.userService = userService;
        Assert.notNull(articleService,"no implication found for articleService ");
        this.articleService = articleService;
    }

    @RequestMapping(value = {"/index", ""})
    public String index(HttpServletRequest request, ModelMap map) throws UnsupportedEncodingException {

        putArticleInfo:{
            User user = (User) request.getSession().getAttribute("user");
            if(user==null){
                break putArticleInfo;
            }
            String type = request.getParameter("type");
            String currentBlogId = request.getParameter("blogId");
            ArticleWithContent articleWithContent =
                    articleService.getArticleByUser(user, currentBlogId, type);
            if(articleWithContent==null){
                break putArticleInfo;
            }
            map.put("article", articleWithContent);
            map.put("content", new String(articleWithContent.getContent(),
                    SystemConstants.DEFAULT_CHARACTER_SET));
        }
        return "index";
    }

    @RequestMapping(value = "/testUE")
    public String testUE() {
        return "ueditor";
    }
}
