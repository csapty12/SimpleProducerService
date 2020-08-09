package com.example.aws.simpleProducerService.producerservice;

import com.example.aws.simpleProducerService.model.Customer;

public interface CustomerService {
	void queue(Customer customer);
	void notify(Customer customer);
}
