package com.example.aws.simpleProducerService.service;

import com.example.aws.simpleProducerService.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

	@Override
	public void send(Customer customer) {
		log.info("sending customer with id {} to queue", customer.getId());

	}
}
