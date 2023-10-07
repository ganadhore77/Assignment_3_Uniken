package com.rabbitmq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rabbitmq.entity.UserEntity;
import com.rabbitmq.producer.ProducerTwo;
import com.rabbitmq.producer.ProducerOne;
import com.rabbitmq.producer.ProducerThree;

@RestController
public class MessageController {

	@Autowired
	private ProducerOne producerOne; 
	
	@Autowired
	private ProducerTwo producerTwo;
	
	@Autowired
	private ProducerThree producerThree;
	
	@GetMapping("/publish")
	public ResponseEntity<String> getMsg(@RequestParam("msg") String msg){
		producerOne.sendMessage(msg);
		
		return ResponseEntity.ok("Message sent to RabbitMQ");
	}
	
	@GetMapping("/publishJsonMsg")
	public ResponseEntity<String> getJsonMsg(@RequestBody UserEntity user) throws JsonProcessingException{
		producerTwo.sendJsonMsg(user);
		 
		return ResponseEntity.ok("JSON Message sent to RabbitMQ");
	}
	
	@GetMapping("/publish1")
	public ResponseEntity<String> getMsg1(@RequestParam("msg") String msg){
		producerThree.sendMessage(msg);
		
		return ResponseEntity.ok("Message sent to RabbitMQ");
	}
	
}
