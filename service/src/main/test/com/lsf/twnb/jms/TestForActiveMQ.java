package com.lsf.twnb.jms;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import proxy.HelloImpl;

import javax.jms.*;
import java.util.HashMap;

/**
 * @author: liusf13201
 * @DATE: 2016/10/9
 */
public class TestForActiveMQ {

    public static void main(String[] args) throws Exception {
        ConnectionFactory cf = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
        Connection conn = cf.createConnection();
        Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = new ActiveMQQueue("spitter.queue");
        if (session != null) {
            MessageProducer producer = session.createProducer(destination);
            TextMessage message = session.createTextMessage();
            for (int i = 0; i < 12; i++) {
                message.setText("I'm kugou"+i);
                HashMap map=new HashMap<String,String>();
                map.put("hello","hi");
                map.put("world","word");
                message.setObjectProperty("abc",map);
                producer.send(message);
            }

            session.close();
        }


    }

}
