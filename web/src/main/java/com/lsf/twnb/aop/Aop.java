package com.lsf.twnb.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by liusifan on 2017/2/19.
 */
@Aspect
@Component
public class Aop {
    @Pointcut("execution(* com.lsf.twnb.controller.*.*(..))")
    public void hello(){

    }
    @Before(value = "hello()")
    public void before(){
        System.out.printf("before");
    }
    @Around(value = "hello()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        return joinPoint.proceed();

    }
    @After(value = "hello()")
    public void after(){
        System.out.printf("after");
    }
}
