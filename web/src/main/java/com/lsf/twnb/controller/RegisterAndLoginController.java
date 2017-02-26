package com.lsf.twnb.controller;

import com.lsf.twnb.entity.User;
import com.lsf.twnb.service.interfaces.IUserService;
import com.lsf.twnb.common.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by liusf13201 on 2015/11/18.
 * 此控制器用于控制用户注册相关操作
 */
@Controller
public class RegisterAndLoginController {
    @Autowired
    IUserService userService;

    /**
     * go to register page.
     *
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "register";
    }

    /**
     * sumit register info, if from other page, then return, else return homepage
     *
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String doRegister(User user, HttpServletRequest request) {
        userService.checkUserLogin(user);
        String backUrl = request.getParameter("backUrl");
        try {
            userService.insert(user);
            request.getSession().setAttribute("user", user);
        } catch (Exception e) {
            return "register";
        }
        if (StringUtil.isNotBlank(backUrl)) {
            return "redirect:" + backUrl;
        } else {
            return "index";
        }
    }

    /**
     *
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String doLogin(User user, HttpServletRequest request,ModelMap map) {
        //return url
        String backUrl=request.getParameter("backUrl");
        /*if the information is correct, go to backUrl if it exists,
        else, give error info*/
        user=userService.getUserByName(user.getUsername()).getItems().get(0);
        if(user==null){
            map.put("errorInfo","username or password is not correct");
            return "redirect:/index";
        }else{
            request.getSession().setAttribute("user",user);
            return backUrl==null?"redirect:/index":"redirect:"+backUrl;
        }

    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/index";
    }
}
