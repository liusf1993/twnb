package com.lsf.twnb.jms;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.util.Assert;

import javax.jms.*;

/**
 * @author: liusf13201
 * @DATE: 2016/10/9
 */
public class ReceiveMessage {
    public static void main(String[] args) throws Exception {
        ConnectionFactory cf = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
        Connection conn = cf.createConnection();
        conn.start();
        Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = new ActiveMQQueue("spitter.queue");

        if (session != null && destination != null) {
            MessageConsumer consumer = session.createConsumer(destination);
            TextMessage message = (TextMessage) consumer.receive();
            System.out.println("Receive A message" + message.getText());
            conn.start();

            session.close();

        }


    }

}
