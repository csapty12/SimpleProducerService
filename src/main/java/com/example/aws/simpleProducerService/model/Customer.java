package com.example.aws.simpleProducerService.model;

import lombok.Data;

@Data
public class Customer {
	private Long id;
	private String name;
	private int age;
	private String email;
}
