package com.ravi.websocket.controller;

import java.security.Principal;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import com.ravi.websocket.dto.Message;
import com.ravi.websocket.dto.ResponseMessage;

@Controller
public class MessageController {
	
	
	@MessageMapping("/message")
	@SendTo("/topic/messages")
	public ResponseMessage getMessage(final Message message) throws InterruptedException {
		Thread.sleep(1000);
		
		return new ResponseMessage(HtmlUtils.htmlEscape(message.getMessageContent()));
	}
	
	@MessageMapping("/private-message")
	@SendToUser("/topic/private-messages")
	public ResponseMessage getPrivateMessage(final Message message,final Principal principal) throws InterruptedException {
		Thread.sleep(1000);
		
		return new ResponseMessage(HtmlUtils.htmlEscape(
				"Sending message to user : "+principal.getName()+ 
				": "+message.getMessageContent()));
	}

}
