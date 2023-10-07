package com.rabbitmq.consumer;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerAll {
	
	@RabbitListener(queues = "queue_all")
	public String consume(Message msg) {

		String payload = new String(msg.getBody());

		String msgid = "Consumer All Correlation ID" + msg.getMessageProperties().getCorrelationId();

		System.out.println("Consumer All message Received " + msgid);

		return msgid;

	}
}
