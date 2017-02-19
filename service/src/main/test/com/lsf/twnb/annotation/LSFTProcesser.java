package com.lsf.twnb.annotation;


import java.lang.reflect.Method;

/**
 * Created by liusf13201 on 2016/11/1.
 */
public class LSFTProcesser {
    public static void test( Class<?> c1){
        for(Method m:c1.getDeclaredMethods()){
            LSFAnnotation l=m.getAnnotation(LSFAnnotation.class);
            if(l!=null){
                System.out.println(l.id());
                System.out.println(l.description());
            }
        }
    }
    public  static  void main(String[] args)
    {
        test(PasswordUtils.class);
    }
}
