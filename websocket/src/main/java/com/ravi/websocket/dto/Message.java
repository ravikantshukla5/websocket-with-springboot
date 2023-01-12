package com.ravi.websocket.dto;

public class Message {

	private String messageContent;

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	@Override
	public String toString() {
		return "Message [messageContent=" + messageContent + "]";
	}
	
}
