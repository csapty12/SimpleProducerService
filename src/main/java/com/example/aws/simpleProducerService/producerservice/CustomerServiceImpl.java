package com.example.aws.simpleProducerService.producerservice;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.example.aws.simpleProducerService.model.Customer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

	@Value("${aws.accessKey}")
	private String awsAccessKey;

	@Value("${aws.secretKey}")
	private String awsSecretKey;

	@Value("${sqs.url}")
	private String sqsURL;

	@Autowired
	private ObjectMapper objectMapper;

	@PostConstruct
	public void setProperty() {
		System.setProperty("aws.accessKeyId", awsAccessKey);
		System.setProperty("aws.secretKey", awsSecretKey);
	}

	@Override
	public void send(Customer customer) {
		AmazonSQS sqs = AmazonSQSClientBuilder.defaultClient();
		log.info("sqs info: {}",sqs);

		try {
			sqs.sendMessage(new SendMessageRequest(sqsURL, objectMapper.writeValueAsString(customer)));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}


	}


}
