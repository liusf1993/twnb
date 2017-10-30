package com.lsf.twnb.common.utils;

/**
 * @author liusf13201
 * created on 2016/11/22
 * class function
 */
public class StringUtil {
    /**
     * 判断字符串是否不为空
     * @param s
     * @return
     */
    public static boolean isNotBlank(String s){
        return s!=null&&s.replaceAll("\\s","").length()!=0;
    }

    /**
     * 判断字符串是否为空
     * @param s
     * @return
     */
    public static boolean isBlank(String s){
        return s==null||s.replaceAll("\\s","").length()==0;
    }
}
