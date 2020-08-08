package com.example.aws.simpleProducerService.controller;

import com.example.aws.simpleProducerService.model.Customer;
import com.example.aws.simpleProducerService.producerservice.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Slf4j
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping("/send")
	public void sendMessage(@RequestBody Customer customer){
		log.info("customer to be saved : " + customer);
		customerService.send(customer);

	}
}
