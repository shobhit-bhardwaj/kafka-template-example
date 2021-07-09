package com.shobhit.kafkaconsumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.shobhit.kafkaconsumer.bean.EmailEvent;

@Service
public class KafkaConsumerService {

	@KafkaListener(topics = "${kafka.topic.name.string}", groupId = "${kafka.group.id.string}", containerFactory = "listenerContainerFactoryString")
	public void consumeString(String message) {
		System.out.println("Consumed String Message - " + message);
	}

	@KafkaListener(topics = "${kafka.topic.name.email}", groupId = "${kafka.group.id.email}", containerFactory = "listenerContainerFactoryEmail")
	public void consumeJsonEmail(EmailEvent message) {
		System.out.println("Consumed Email Message - " + message);
	}
}