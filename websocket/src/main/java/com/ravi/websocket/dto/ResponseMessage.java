package com.ravi.websocket.dto;

public class ResponseMessage {
	
	public ResponseMessage(String content) {
		this.content = content;
	}

	public ResponseMessage() {
		
	}

	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "ResponseMessage [content=" + content + "]";
	}
	
	

}
