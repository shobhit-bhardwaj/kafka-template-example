package com.shobhit.kafkaproducer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shobhit.kafkaproducer.bean.EmailEvent;
import com.shobhit.kafkaproducer.bean.ErrorLogEvent;
import com.shobhit.kafkaproducer.service.MessageService;

@RestController
@RequestMapping("/message")
public class MessageController {

	@Autowired
	private MessageService messageService;

	@RequestMapping(value = "/plain/{message}", method = RequestMethod.GET)
	public String publishPlainMessage(@PathVariable String message) {
		return messageService.publishStringMessage(message);
	}

	@RequestMapping(value = "/event/email", method = RequestMethod.POST)
	public String publishEmailEvent(@RequestBody EmailEvent event) {
		System.out.println(event);
		return messageService.publishEvent(event);
	}

	@RequestMapping(value = "/event/errorlog", method = RequestMethod.POST)
	public String publishErrorLogEvent(@RequestBody ErrorLogEvent event) {
		return messageService.publishEvent(event);
	}
}