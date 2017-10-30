package com.lsf.twnb.service.interfaces.interact;

import com.lsf.twnb.exception.TwnbException;

/**
 * Created by liusifan on 2017/3/12.
 * 接收数据接口
 */
public interface DataReceiveInteract extends DataInteract {
    /**
     * 交互方式为接收
     * @return 交互方式
     */
    @Override
    default INTERACT_TYPE getInteractType(){
        return INTERACT_TYPE.SEND;
    }

    @Override
    default  Object interact(Object... args) throws TwnbException{
        return dealReturnData(args);
    }
}
