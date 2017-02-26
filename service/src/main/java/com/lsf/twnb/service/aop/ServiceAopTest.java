package com.lsf.twnb.service.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by liusifan on 2017/2/19.
 */
@Component
@Aspect
public class ServiceAopTest {
    @Pointcut("execution(* com.lsf.twnb.service.interfaces.IUserService.checkUserLogin(..))")
    public void hello(){

    }
    @Before("hello()")
    public void before(){
        System.out.printf("hello");
    }

    @After("hello()")
    public void after(){
        System.out.printf("after");
    }
    @Around("hello()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        return joinPoint.proceed();
    }
}
