package com.lsf.twnb.service.interfaces.interact;

import com.lsf.twnb.exception.TwnbException;

/**
 * Created by liusifan on 2017/3/12.
 * class function 数据交互接口
 */
public interface DataInteract {
    /**
     * 交互成功代码
     */
    public static final String SUCCESS_CODE="1";
    /**
     * 交互失败代码
     */
    public static final String FAILURE_CODE="0";
    /**
     * 代码key值，常量，保证所有代码的key值统一
     */
    public static final String RESULT_KEY="code";

    /**
     * 数据key值，常量，保证所有代码的key值统一
     */
    public static final String DATA_KEY="data";

    INTERACT_TYPE getInteractType();


    /**
     * 交互类型，发送和接收
     */
    enum INTERACT_TYPE{
        //发送
        SEND,
        //接收
        RECEIVE
    }

    Object dealReturnData(Object... args) throws TwnbException;

    Object interact(Object... args) throws TwnbException;

}
