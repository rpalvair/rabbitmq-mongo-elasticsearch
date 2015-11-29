package com.palvair.controller;

import com.palvair.View;
import lombok.extern.log4j.Log4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by widdy on 29/11/2015.
 */
@Controller
@Log4j
public class HomeController {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        final View view = new View();
        view.setPage("index");
        amqpTemplate.convertAndSend("view",view);
        return "index";
    }
}
