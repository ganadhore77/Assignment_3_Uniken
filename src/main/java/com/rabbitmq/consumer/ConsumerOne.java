package com.rabbitmq.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerOne {

	private static final Logger logger = LoggerFactory.getLogger(ConsumerOne.class);

	@RabbitListener(queues = "queue_one" )
	public String consume(Message msg) {
		
		String payload = new String(msg.getBody());

		String msgid = "Consumer One Correlation ID" + msg.getMessageProperties().getCorrelationId();

		System.out.println("Consumer One message Received " + msgid);
		
		return msgid;

	}

}
