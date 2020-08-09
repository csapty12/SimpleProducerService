package com.example.aws.simpleProducerService.config;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.CreateQueueRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SQSConfig {

	@Value("${aws.sqs.host}")
	private String hostname;

	@Value("${aws.region}")
	private String region;

	@Value("${aws.sqs.queue-name}")
	private String queueName;

	@Bean
	public AmazonSQS amazonSQS(final AWSCredentialsProvider awsCredentialsProvider) {

		AmazonSQS sqs = AmazonSQSClientBuilder.standard().withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(hostname, region))
				.withCredentials(awsCredentialsProvider)
				.build();
		sqs.createQueue(new CreateQueueRequest(queueName));
		return sqs;
	}
}
