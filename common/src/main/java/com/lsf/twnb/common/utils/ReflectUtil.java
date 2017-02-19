package com.lsf.twnb.common.utils;

import java.lang.reflect.Field;

/**
 * Created by liusifan on 2017/2/11.
 */
public class ReflectUtil {
    public static  Object getField(Object target,String filedName) throws NoSuchFieldException, IllegalAccessException {
        Field field=target.getClass().getDeclaredField(filedName);
        return getField(target,field);
    }



    public static Object getField(Object target ,Field field) throws IllegalAccessException {
        if(field.isAccessible()){
            return getAccessibleField(target,field);
        }else{
            return getNoAccessibleField(target,field);
        }
    }

    private static Object getAccessibleField(Object target,Field field) throws IllegalAccessException {
        return field.get(target);
    }

    private  synchronized static Object getNoAccessibleField(Object target, Field field) throws IllegalAccessException {
        field.setAccessible(true);
        Object fieldValue=field.get(target);
        field.setAccessible(false);
        return fieldValue;
    }

    public static void setField(Object target,String fieldName,Object fieldValue) throws NoSuchFieldException, IllegalAccessException {
        Field field =target.getClass().getDeclaredField(fieldName);
        if(!field.isAccessible()){
            field.setAccessible(true);
            field.set(target,fieldValue);
            field.setAccessible(false);
        }else{
            field.set(target,fieldValue);
        }
    }


}
