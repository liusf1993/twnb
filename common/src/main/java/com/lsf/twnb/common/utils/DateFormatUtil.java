package com.lsf.twnb.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期格式化工具类
 */
public class DateFormatUtil {
    /**
     * 时分 hh:mm
     */
    public static final String TIME_PATTERN="hh:mm";
    /**
     * 时分秒 hh:mm:ss
     */
    public static final String TIME_PATTERN_1="hh:mm:ss";
    /**
     * 年月日 yyyy-MM-dd
     */
    public static final String DATE_PATTERN="yyyy-MM-dd";
    /**
     * 月日 MM-DD
     */
    public static final String DATE_PATTERN_1="MM-dd";
    /**
     * 完整的时间  yyyy-MM-dd hh:mm:ss
     */
    public static final String DATE_PATTERN_FULL="yyyy-MM-dd hh:mm:ss";

    public static String format(Date date, String format){
        if(date==null){
            return "";
        }
        SimpleDateFormat sdf=new SimpleDateFormat(format);
        return sdf.format(date);
    }
}
