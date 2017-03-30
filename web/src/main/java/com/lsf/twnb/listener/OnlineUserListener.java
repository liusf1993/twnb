package com.lsf.twnb.listener;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @Author liusifan
 * @Date 2017/3/30
 * @Description
 */
public class OnlineUserListener implements ApplicationContextAware,ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {


    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }
}
