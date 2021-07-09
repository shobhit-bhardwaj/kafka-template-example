package com.shobhit.kafkaconsumer.bean;

public enum EventTypes {
	EMAIL ("EMAIL"),
	ErrorLog("ERROR_LOG");

	private String name;

	private EventTypes(String name) {
		this.name = name;
	}

	public String getType() {
		return this.name;
	}
}