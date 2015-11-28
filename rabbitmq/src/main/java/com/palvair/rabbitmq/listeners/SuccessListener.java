package com.palvair.rabbitmq.listeners;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

import java.nio.charset.Charset;

public class SuccessListener implements MessageListener {

    private String targetRoutingKey;
    private AmqpTemplate amqpTemplate;
    private Message message;

    public void setTargetRoutingKey(String targetRoutingKey) {
        this.targetRoutingKey = targetRoutingKey;
    }

    public void setAmqpTemplate(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public void onMessage(Message message) {
        this.message = message;
        System.out.println("[SUCCESS LISTENER] Message Received :" + message.toString());
        System.out.println("[SUCCESS LISTENER] Body of the message : " + new String(message.getBody(), Charset.forName("UTF-8")));
    }

    public Message getMessage() {
        return this.message;
    }

    public void reset() {
        this.message = null;
    }
}
