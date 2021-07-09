package com.shobhit.kafkaconsumer.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.shobhit.kafkaconsumer.bean.EmailEvent;

@EnableKafka
@Configuration
public class ApplicationConfig {

	@Value("${kafka.server.host}:${kafka.server.port}")
	private String kafkaServer;

	@Value("${kafka.group.id.string}")
	private String groupIdString;

	@Value("${kafka.group.id.email}")
	private String groupIdEmail;

	@Bean
	public ConsumerFactory<String, String> consumerFactoryString() {
		Map<String, Object> config = new HashMap<>();
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaServer);
		config.put(ConsumerConfig.GROUP_ID_CONFIG, groupIdString);
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);

		return new DefaultKafkaConsumerFactory<String, String>(config);
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, String> listenerContainerFactoryString() {
		ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactoryString());

		return factory;
	}

	@Bean
	public ConsumerFactory<String, EmailEvent> consumerFactoryEmail() {
		Map<String, Object> config = new HashMap<>();
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaServer);
		config.put(ConsumerConfig.GROUP_ID_CONFIG, groupIdEmail);
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);

		return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(), new JsonDeserializer<>(EmailEvent.class));
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, EmailEvent> listenerContainerFactoryEmail() {
		ConcurrentKafkaListenerContainerFactory<String, EmailEvent> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactoryEmail());

		return factory;
	}
}