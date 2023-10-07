package com.rabbitmq.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.AsyncRabbitTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.support.converter.SmartMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQ_Config {

	/* ------- Queues ------*/
	@Bean
	public Queue queue1() {
		return new Queue("queue_one");
	}
	
	@Bean
	public Queue queue2() {
		return new Queue("queue_two");
	}
	
	@Bean
	public Queue queue3() {
		return new Queue("queue_three");
	}
	
	@Bean
	public Queue queue4() {
		return new Queue("queue_four");
	}

	@Bean
	public Queue all() {
		return new Queue("queue_all");
	}
	
	/* ------- Exchanges ------*/
	@Bean
	public FanoutExchange fanoutExchange() {
		return new FanoutExchange("fanout");
	}
	
	@Bean
	public TopicExchange topicExchange() {
		return new TopicExchange("TExchange");
	}

	/*----- Binding between Queue and Exchange using Routing Key ---- */
	@Bean
	public Binding queue1binding() {
		return BindingBuilder.bind(queue1()).to(topicExchange()).with("producer.one");
//		return BindingBuilder.bind(queue1()).to(fanoutExchange());
	}
	
	@Bean
	public Binding jsonBinding() {
		return BindingBuilder.bind(queue2()).to(topicExchange()).with("producer.two");
	}
	
	@Bean
	public Binding queue3Binding() {
		return BindingBuilder.bind(queue3()).to(topicExchange()).with("producer.three");
//		return BindingBuilder.bind(queue3()).to(fanoutExchange());
	}
	
	@Bean
	public Binding queue4Binding() {
		return BindingBuilder.bind(queue4()).to(topicExchange()).with("producer.one");
	}
	
	@Bean
	public Binding allBinding() {
		return BindingBuilder.bind(all()).to(topicExchange()).with("producer.*");
	}
	
	
	
	@Bean
	public Jackson2JsonMessageConverter msgConverter() {
		return new Jackson2JsonMessageConverter();
	}
			
	@Bean
	public AsyncRabbitTemplate asyncRabbitTemplate(RabbitTemplate rabbitTemplate){
		return new AsyncRabbitTemplate(rabbitTemplate);
	}
	
}
