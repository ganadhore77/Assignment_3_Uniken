package com.rabbitmq.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.rabbitmq.entity.Reply;
import com.rabbitmq.entity.UserEntity;

@Service
public class ConsumerTwo {
	
	private static final Logger logger = LoggerFactory.getLogger(ConsumerTwo.class);

	@RabbitListener(queues = "queue_two")
	public Reply consumeJson(UserEntity msg) {

		
		Reply reply = new Reply();
		
		reply.setId(msg.getId());
		reply.setFirstName(msg.getFirstName());
		reply.setLastName(msg.getLastName());
		
		System.out.println("Consumer Two Received  : : "+reply.toString());
		return reply;
	}
	
}
