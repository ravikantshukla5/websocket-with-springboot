package com.ravi.websocket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ravi.websocket.dto.Message;
import com.ravi.websocket.service.WebsocketService;

@RestController
public class WSController {
	
	private final WebsocketService websocketService;
	
	@Autowired
	public WSController(WebsocketService websocketService) {
		this.websocketService = websocketService;
	}
	
	@PostMapping("/send-message")
	public void sendMessage(@RequestBody Message message) {
		websocketService.notifyFrontend(message.getMessageContent());
	}
	@PostMapping("/send-private-message/{id}")
	public void sendPrivateMessage(@PathVariable String id,@RequestBody final Message message) {
		websocketService.notifyFrontend(id,message.getMessageContent());
	}

}
