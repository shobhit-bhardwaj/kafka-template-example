package com.shobhit.kafkaproducer.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailEvent {
	private String TYPE = EventTypes.EMAIL.getType();

	private String from;
	private String to;
	private String message;
}