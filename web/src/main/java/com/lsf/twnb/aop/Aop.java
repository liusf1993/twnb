package com.lsf.twnb.aop;

import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by liusifan on 2017/2/19.
 */
@Aspect
@Component
public class Aop {
    Logger logger= LoggerFactory.getLogger(this.getClass());
    @Pointcut("execution(* com.lsf.twnb.controller..*(..))")
    public void action(){

    }

    @Around("action()")
    public Object aroundAction(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("前台请求开始，请求参数如下:{}",joinPoint.getArgs());
        return joinPoint.proceed();

    }
}
