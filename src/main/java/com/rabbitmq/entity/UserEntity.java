package com.rabbitmq.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5403954307286829148L;
	private int id;
	private String firstName;
	private String lastName;
	
}
