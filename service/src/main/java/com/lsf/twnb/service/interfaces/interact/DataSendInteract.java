package com.lsf.twnb.service.interfaces.interact;

import com.lsf.twnb.exception.TwnbException;

/**
 * Created by liusifan on 2017/3/12.
 * @Description 数据发送交互
 */
public interface DataSendInteract extends DataInteract {
    /**
     * 交互方式为发送
     * @return 交互方式
     */
    default INTERACT_TYPE getInteractType(){
        return INTERACT_TYPE.SEND;
    }

    default Object interact(Object... args) throws TwnbException{
        //验证发送数据
        checkSendData(args);
        //发送数据并接收舞台数据
        Object returnData=sendData(args);
        //对接收到的数据进行处理
        return dealReturnData(args);
    }

    /**
     * 发送数据
     * @param args 发送的数据
     * @return 交互返回的数据
     */
    Object sendData(Object... args) throws TwnbException;

    /**
     * 校验发送数据的正确性
     * @param args 交互的数据
     */
    void checkSendData(Object... args) throws TwnbException;
}
