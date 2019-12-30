package com.javainuse.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.javainuse.model.Message;

@Service
public class RabbitMQSender {

	@Value("${rabbitmq.exchange}")
	private String exchange;

	@Value("${rabbitmq.routingkey}")
	private String routingkey;

	private AmqpTemplate amqpTemplate;


	@Autowired
	public RabbitMQSender(AmqpTemplate amqpTemplate) {
		this.amqpTemplate = amqpTemplate;
	}

	public void send(Message message) {
		amqpTemplate.convertAndSend(exchange, routingkey, message);
		System.out.println("Send msg = " + message);
	    
	}
}