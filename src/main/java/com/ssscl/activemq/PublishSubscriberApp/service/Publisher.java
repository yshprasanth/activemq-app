package com.ssscl.activemq.PublishSubscriberApp.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssscl.activemq.PublishSubscriberApp.domain.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

@Component
public class Publisher {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(Publisher.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private MessageConverter messageConverter;

    public void send(Message message) {
        LOGGER.info("sending message='{}'", message);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            jmsTemplate.convertAndSend("message-box", objectMapper.writeValueAsString(message));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
