package com.rabbitmq.producer;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.AsyncRabbitTemplate;
import org.springframework.amqp.rabbit.RabbitConverterFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.entity.Reply;
import com.rabbitmq.entity.UserEntity;

@Service
public class ProducerTwo {

	private static final Logger logger = LoggerFactory.getLogger(ProducerTwo.class);

	@Autowired
	private TopicExchange tExchange;

	@Autowired
	public AsyncRabbitTemplate rabbitTemplate;

	public void sendJsonMsg(UserEntity user) throws JsonProcessingException {

		RabbitConverterFuture<Reply> receive = rabbitTemplate.convertSendAndReceive(tExchange.getName(), "producer.two", user);
		
		System.out.println("Producer Two publish message using tpoic exchange: "+user);
		
		receive.whenComplete((receivedMsg, exception) -> {
			if (exception != null) {
				System.out.println(exception);
			} else {
				System.out.println("Producer Two : "+receivedMsg);
			}

		});
	}

}
