package com.palvair.rabbitmq.listeners;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

import java.nio.charset.Charset;

public class ErrorListener implements MessageListener {

    private String messageBody = null;

    public void onMessage(Message message) {
        System.out.println("[ERROR LISTENER] Message Received : " + message.toString());
        System.out.println("[ERROR LISTENER] Body of the message : " + new String(message.getBody(), Charset.forName("UTF-8")));
        this.messageBody = new String(message.getBody(), Charset.forName("UTF-8"));
    }

    public String getMessageBody() {
        return this.messageBody;
    }
}
