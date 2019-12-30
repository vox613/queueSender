package com.javainuse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

	@GetMapping(value = "/msg")
    public String producer(@RequestParam("text") String msgText) {
        Message msg = new Message();
		msg.setMsgText(msgText);
        rabbitMQSender.send(msg);
        return "Message sent to the RabbitMQ Successfully";
    }

}

