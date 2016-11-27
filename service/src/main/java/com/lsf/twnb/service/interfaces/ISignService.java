package com.lsf.twnb.service.interfaces;

import com.lsf.twnb.entity.Sign;

/**
 * Created by liusf13201 on 2015/11/18.
 */
public interface ISignService
{
    public void insert(Sign sign);
    public void updateByUsername(Sign sign);
}
