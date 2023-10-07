package com.rabbitmq.consumer;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerFour {

	@RabbitListener(queues = "queue_four")
	public String consume(Message msg) {

		String payload = new String(msg.getBody());

		String msgid = "Consumer Four Correlation ID" + msg.getMessageProperties().getCorrelationId();

		System.out.println("Consumer Four message Received " + msgid);

		return msgid;

	}
	
}
