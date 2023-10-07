package com.rabbitmq.consumer;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerThree {
	
	@RabbitListener(queues = "queue_three" )
	public String consume(Message msg) {

		String msgid = "Consumer Three Correlation ID" + msg.getMessageProperties().getCorrelationId();
				
		System.out.println("Consumer Three message Received " + msgid);
		
		return msgid;

	}
}
