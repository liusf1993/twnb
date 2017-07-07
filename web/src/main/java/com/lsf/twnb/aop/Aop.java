package com.lsf.twnb.aop;

import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.support.PropertySourceFactory;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

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
        logger.info("前台请求开始，请求参数如下:{}",arrayToString(joinPoint.getArgs()));
        return joinPoint.proceed();

    }

    private String arrayToString(Object[] args) {
        Map m=new JSONObject();
        for (Object arg : args) {
            if(arg instanceof HttpServletRequest){
                m.put("abc","request");
            }else if(arg instanceof HttpSession){
                m.put("def","sessoin");
            }else{
                m.put("other",arg);
            }
        }
        return m.toString();
    }
}
