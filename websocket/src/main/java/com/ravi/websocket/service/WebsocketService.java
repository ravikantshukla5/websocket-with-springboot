package com.ravi.websocket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.ravi.websocket.dto.ResponseMessage;

@Service
public class WebsocketService {
	
	private final SimpMessagingTemplate simpMessagingTemplate;
	
	@Autowired
	public WebsocketService(SimpMessagingTemplate simpMessagingTemplate) {
		this.simpMessagingTemplate = simpMessagingTemplate;
	}
	
	public void notifyFrontend(final String message) {
		ResponseMessage responseMessage = new ResponseMessage(message);
		this.simpMessagingTemplate.convertAndSend("/topic/messages", responseMessage);
	}
	public void notifyFrontend(final String id,final String message) {
		ResponseMessage responseMessage = new ResponseMessage(message);
		this.simpMessagingTemplate.convertAndSendToUser(id,"/topic/private-messages",responseMessage);
	}

}
