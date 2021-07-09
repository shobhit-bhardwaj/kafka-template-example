package com.shobhit.kafkaproducer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

	@Autowired
	private KafkaProducerService producerService;

	public String publishStringMessage(String name) {
		producerService.publishMessagetoKafka(name);

		return "Message (String) Publish Successfully";
	}

	public <T> String publishEvent(T event) {
		producerService.publishMessagetoKafka(event);

		return "Message (Event) Publish Successfully";
	}
}