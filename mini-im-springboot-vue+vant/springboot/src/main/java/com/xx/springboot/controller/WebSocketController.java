package com.xx.springboot.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
/**
 * @className: WebSocketController
 * @description: TODO 类描述
 * @date: 2024/10/11
 **/
@Controller
public class WebSocketController {

    Logger logger = LoggerFactory.getLogger(WebSocketController.class);

    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")
    public String processMessageFromClient(String message) {
        logger.info("Received message: " + message);
        return "Server response: " + message;
    }
}
