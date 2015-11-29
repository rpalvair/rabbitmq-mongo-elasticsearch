package com.palvair.rabbitmq.listeners;

import com.palvair.View;
import com.palvair.services.MongoViewService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class SuccessListener {

    private String targetRoutingKey;
    private AmqpTemplate amqpTemplate;

    @Autowired
    private MongoViewService mongoViewService;

    public void setTargetRoutingKey(String targetRoutingKey) {
        this.targetRoutingKey = targetRoutingKey;
    }

    public void setAmqpTemplate(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }


    public void handleView(View message) {
        System.out.println("view = "+message);
        mongoViewService.save(message);
    }
}
