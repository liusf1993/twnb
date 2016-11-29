package com.lsf.twnb.base;

import com.lsf.twnb.service.interfaces.IUserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author liusf13201
 * @Date 2016/11/29
 * @Description
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml",})
public class BaseTest {
    @Autowired
    IUserService userService;
    @Test
    public void isConfigProper(){
        Assert.assertTrue(userService!=null);
    }
}
