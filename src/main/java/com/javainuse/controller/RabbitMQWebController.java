package com.javainuse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.javainuse.model.Message;
import com.javainuse.service.RabbitMQSender;

@RestController
@RequestMapping(value = "/")
public class RabbitMQWebController {

    private RabbitMQSender rabbitMQSender;

    @Autowired
	public RabbitMQWebController(RabbitMQSender rabbitMQSender) {
        this.rabbitMQSender = rabbitMQSender;
	}


    // localhost:8080/msg/?text=123


    @PostMapping("/msg")
    private String postProducer(@RequestBody Message messageEntity) {
        System.out.println("getMsgText = " + messageEntity.getMsgText());
        rabbitMQSender.send(messageEntity);
        return "index";
    }

}

