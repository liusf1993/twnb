package com.lsf.twnb.service.impl;

import com.lsf.twnb.base.BaseTest;
import com.lsf.twnb.entity.User;
import com.lsf.twnb.service.interfaces.IUserService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author liusf13201
 * created on 2016/11/28
 * class function
 */
public class UserServiceImplTest extends BaseTest {
    @Autowired
    IUserService userService;

    @Test
    public void insert() throws Exception {
        User newUser = new User();
        newUser.setUsername("lsf-test");
        newUser.setName("刘思凡");
        userService.deleteUserByUsername("lsf-test");

        userService.insert(newUser);

        User user = userService.getUserByName(newUser.getUsername()).getItems().get(0);
        Assert.assertEquals(user.getUsername(), newUser.getUsername());


    }

    @Test
    public void updateById() throws Exception {

    }

    @Test
    public void getUserByName() throws Exception {

    }

    @Test
    public void checkUserLogin() throws Exception {

    }

}