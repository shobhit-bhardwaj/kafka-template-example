package com.shobhit.kafkaproducer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
	@Value("${kafka.topic.name}")
	private String topicName;

	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;

	public <T> void publishMessagetoKafka(T message) {
		kafkaTemplate.send(topicName, message);
	}
}