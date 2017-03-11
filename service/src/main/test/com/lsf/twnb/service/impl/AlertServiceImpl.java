package com.lsf.twnb.service.impl;

import com.lsf.twnb.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;
import proxy.IHello;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * Created by liusifan on 2017/2/27.
 */
@Service
public class AlertServiceImpl implements AlertService {
    @Autowired
    private JmsTemplate jmsTemplate;

    @Override
    public void sendAlertInfo(IHello hello) {
        jmsTemplate.send("queue", session -> session.createObjectMessage(hello));
        jmsTemplate.receive("");
    }

}
