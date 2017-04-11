package com.lsf.twnb.controller.blog;

import com.lsf.twnb.constants.SessionConstants;
import com.lsf.twnb.entity.ArticleWithContent;
import com.lsf.twnb.entity.User;
import com.lsf.twnb.exception.TwnbException;
import com.lsf.twnb.service.interfaces.IArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.lsf.twnb.query.concrete.BlogPageQuery;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Controller for manager blog
 */
@Controller
@RequestMapping("/blog")
public class BlogController {

    private Logger logger= LoggerFactory.getLogger(this.getClass());
    private final String PREFIX="blog";
    private IArticleService blogService;


    /**
     * 获取博文列表
     * @param blogService
     */
    @Autowired
    public BlogController(IArticleService blogService) {
        this.blogService = blogService;
    }
    @RequestMapping(value = "/getBlogList.htm")
    public String getBlogList(HttpServletRequest request, HttpSession session, ModelMap map,
                              BlogPageQuery blogPageQuery){
        User user= (User) session.getAttribute(SessionConstants.USER);
        blogPageQuery.setUserName(user.getUsername());
        BlogPageQuery articleList= blogService.queryArticleList(blogPageQuery);
        map.put("queryResult",articleList);
        return PREFIX+"/blogList";
    }

    /**
     *根据文章ID查看博文
     * @param blogId
     * @param request
     * @param map
     * @return
     * @throws TwnbException
     */
    @RequestMapping(value="/viewBlog/{blogId}.htm")
    public String viewBlog(@PathVariable int blogId,HttpServletRequest request,ModelMap map) throws TwnbException {
        ArticleWithContent articleWithContent= blogService.getArticleById(blogId);
        map.put("blog",articleWithContent);
        return PREFIX+"/blog";
    }

    /**
     * 进入发布文章页面
     * @param session
     * @return
     */
    @RequestMapping(value = "/postBlog.htm", method = RequestMethod.GET)
    public String toPostArticle(HttpSession session) {
        return "article/postBlog";

    }

    /**
     * 发布文章
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/postBlog.htm", method = RequestMethod.POST)
    public String doPostArticle( HttpServletRequest request) throws Exception {
        JmsTemplate js=new JmsTemplate();
        User user= (User) request.getSession().getAttribute("user");
        String content=request.getParameter("blogContent");

        String keyWord=request.getParameter("keyWord");
        String title=request.getParameter("title");
        ArticleWithContent article=new ArticleWithContent();
        article.setTitle(title);
        article.setAuthor(user.getUsername());
        article.setTitle(title);
        article.setAuthor(user.getUsername());
        article.setKeyWord(keyWord);
        article.setContent(content.getBytes("utf8"));
        blogService.saveArticle(article);

        return "article/postBlog";

    }



}
