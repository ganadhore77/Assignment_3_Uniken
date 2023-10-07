package com.rabbitmq.producer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.AsyncRabbitTemplate;
import org.springframework.amqp.rabbit.RabbitConverterFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProducerThree {

	@Autowired
	private TopicExchange tExchange;
	
	@Autowired
	public AsyncRabbitTemplate rabbitTemplate;

	public void sendMessage(String msg) {
		List<RabbitConverterFuture<String>> list = new ArrayList<>();
//		logger.info(String.format("Mesaage sent -> %s", msg));
		
		System.out.println("Mesaage sent -> "+ msg);
		RabbitConverterFuture<String> receive = rabbitTemplate.convertSendAndReceive(tExchange.getName(), "producer.one", msg);
//		RabbitConverterFuture<String> receive = rabbitTemplate.convertSendAndReceive(fanout.getName(), "producer.one", msg);
		
		list.add(receive);
		
//		receive.whenComplete((receivedMsg, exception) -> {
//			if (exception != null) {
//				System.out.println(exception);
//			} else {
//				System.out.println(receivedMsg);
//			}
//		});
				
		list.forEach(n->n.whenComplete((result,ex)->{
			if (ex != null) {
				System.out.println("Message processing failed: " + msg);
				System.out.println("Message processing failed: Exception Msg: " + ex.getMessage());
				ex.printStackTrace();
			}
			System.out.println("Producder Three Received Response from Consumer with Corelation ID :: "+result);
    	}));

	}
}
