package com.palvair.rabbitmq.listeners;

import com.palvair.View;
import org.springframework.amqp.core.AmqpTemplate;

public class SuccessListener {

    private String targetRoutingKey;
    private AmqpTemplate amqpTemplate;

    public void setTargetRoutingKey(String targetRoutingKey) {
        this.targetRoutingKey = targetRoutingKey;
    }

    public void setAmqpTemplate(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }


    public void handleView(View message) {
        System.out.println("view = "+message);
    }
}
