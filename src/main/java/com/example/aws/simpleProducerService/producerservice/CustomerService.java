package com.example.aws.simpleProducerService.producerservice;

import com.example.aws.simpleProducerService.model.Customer;

public interface CustomerService {
	void notify(Customer customer);
}
