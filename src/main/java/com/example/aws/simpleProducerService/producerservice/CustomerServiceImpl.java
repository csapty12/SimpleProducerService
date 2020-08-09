package com.example.aws.simpleProducerService.producerservice;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.CreateTopicRequest;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.CreateQueueRequest;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageResult;
import com.example.aws.simpleProducerService.model.Customer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

	private final ObjectMapper objectMapper;

	private final AmazonSQS sqs;
	private final AmazonSNS sns;

	public CustomerServiceImpl(ObjectMapper objectMapper, AmazonSQS sqs, AmazonSNS sns) {
		this.objectMapper = objectMapper;
		this.sqs = sqs;
		this.sns = sns;
	}

	@Override
	public void send(Customer customer) {
		String myQueue = sqs.createQueue(new CreateQueueRequest("my-first-queue")).getQueueUrl();
		String myTopicArn = sns.createTopic(new CreateTopicRequest("topicName")).getTopicArn();
		System.out.println("my topic: " + myTopicArn);
		System.out.println("my queue: " + myQueue);

//		try {
//			SendMessageResult sendMessageResult = sqs.sendMessage(new SendMessageRequest(myQueue, objectMapper.writeValueAsString(customer)));
//			System.out.println("send message result: "+ sendMessageResult.getMessageId());
//		} catch (JsonProcessingException e) {
//			e.printStackTrace();
//		}
	}
}
