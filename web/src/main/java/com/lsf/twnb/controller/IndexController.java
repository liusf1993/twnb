package com.lsf.twnb.controller;

import com.lsf.twnb.constants.SessionConstants;
import com.lsf.twnb.entity.User;
import com.lsf.twnb.exception.TwnbException;
import com.lsf.twnb.service.interfaces.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;


/**
 * Controller for homePage
 */
@Controller
public class IndexController {
    @Autowired
    private IArticleService blogService;

    @Autowired
    public IndexController(IArticleService blogService) {
        this.blogService = blogService;
        Assert.notNull(blogService, "no implication found for blogService ");
    }

    @RequestMapping(value = {"/index.htm"})
    public String index(HttpSession session,
                         Integer blogId, String type,ModelMap map) throws TwnbException {
        //session中的用户信息
        String username = (String) session.getAttribute(SessionConstants.USERNAME_ATTRIBUTE);
        map.put("blog",blogService.getArticleByUser(username,blogId,type));
        return "index";
    }

    @RequestMapping(value = "/testUE")
    public String testUE() {
        return "ueditor";
    }
}
