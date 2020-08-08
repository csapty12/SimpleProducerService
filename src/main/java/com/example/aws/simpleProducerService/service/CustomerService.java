package com.example.aws.simpleProducerService.service;

import com.example.aws.simpleProducerService.model.Customer;

public interface CustomerService {
	void send(Customer customer);
}
