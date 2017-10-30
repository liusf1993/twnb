package com.lsf.twnb.service.impl;

import com.lsf.twnb.dao.SignMapper;
import com.lsf.twnb.entity.Sign;
import com.lsf.twnb.service.interfaces.ISignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by liusf13201 on 2015/11/18.
 */
@Component
public class SignServiceImpl implements ISignService
{
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private SignMapper entityMapper;
    @Override
    public void insert(Sign sign)
    {
        entityMapper.insert(sign);
    }

    @Override
    public void updateByUsername(Sign sign)
    {
        entityMapper.updateByUsername(sign);
    }
}
