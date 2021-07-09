package com.shobhit.kafkaconsumer.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorLogEvent {
	private String TYPE = EventTypes.ErrorLog.getType();

	private int errorCode;
	private String errorMessage;
}