package com.lsf.twnb.jms;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

import javax.jms.*;

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
            message.setText("one apple");
            producer.send(message);
            session.close();
        }


    }

}
