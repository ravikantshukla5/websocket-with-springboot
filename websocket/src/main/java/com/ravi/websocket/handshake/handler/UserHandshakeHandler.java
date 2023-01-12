package com.ravi.websocket.handshake.handler;
import java.nio.file.attribute.UserPrincipal;
import java.security.Principal;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

public class UserHandshakeHandler extends DefaultHandshakeHandler{
	
	Logger log = LoggerFactory.getLogger(UserHandshakeHandler.class);

	@Override
	protected Principal determineUser(ServerHttpRequest request, WebSocketHandler wsHandler,
			Map<String, Object> attributes) {
		final String randomUserId = UUID.randomUUID().toString();
		log.info("User with ID '{}' opened the page ",randomUserId);
		return new UserPrincipal() {
			
			@Override
			public String getName() {
				return randomUserId;
			}
		};
	}
	
	

}
