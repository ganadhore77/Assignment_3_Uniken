package com.rabbitmq.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@AllArgsConstructor
@NoArgsConstructor
public class Reply {

	private int id;
	private String firstName;
	private String lastName;
	private String correlationId;
}
