package com.lsf.twnb.controller;

import com.lsf.twnb.entity.User;
import com.lsf.twnb.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by liusf13201 on 2015/11/18.
 */
@Controller
@RequestMapping(value="/xx")
public class RegisterController
{
    @Autowired
    IUserService userService;
    @ResponseBody
    @RequestMapping(value="/register")
    public String register(User user)
    {
        userService.insert(user);
        return "success";
    }
}
