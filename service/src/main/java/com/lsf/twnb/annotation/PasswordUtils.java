package com.lsf.twnb.annotation;

/**
 * Created by liusf13201 on 2016/11/1.
 */

public class PasswordUtils {
    @LSFAnnotation(id=1)
    public boolean isValidPassword(String password){
        return password.matches("\\w*\\d\\w");
    }
    @LSFAnnotation(id=10086,description = "人生自古谁无死，留取丹心照汉青")
    public boolean aaa(String password){
        return password.matches("\\w*\\d\\w");
    }
}
