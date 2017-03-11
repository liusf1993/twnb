package com.lsf.twnb.service;

import proxy.HelloImpl;
import proxy.IHello;

/**
 * Created by liusifan on 2017/2/27.
 */
public interface AlertService {
    void sendAlertInfo(IHello hello);
}
