package com.example.aws.simpleProducerService.config;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.amazonaws.services.sns.model.CreateTopicRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SNSConfig {

	@Value("${aws.sns.host}")
	private String hostname;

	@Value("${aws.region}")
	private String region;

	@Value("${aws.sns.topic-name}")
	private String topicName;
	@Bean
	public AmazonSNS amazonSNS(final AWSCredentialsProvider awsCredentialsProvider) {
		AmazonSNS sns = AmazonSNSClientBuilder.standard().withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(hostname, region))
				.withCredentials(awsCredentialsProvider)
				.build();
		sns.createTopic(new CreateTopicRequest(topicName));
		return sns;
	}
}
