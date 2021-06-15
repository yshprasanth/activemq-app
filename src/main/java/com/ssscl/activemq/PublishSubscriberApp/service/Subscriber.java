package com.ssscl.activemq.PublishSubscriberApp.service;

import com.ssscl.activemq.PublishSubscriberApp.domain.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
public class Subscriber {

//    @JmsListener(destination = "message-box", containerFactory = "messageBoxFactory")
//    public void receiveMessage(Message message) {
//        System.out.println("Received <" + message + ">");
//    }

    private static final Logger LOGGER =
            LoggerFactory.getLogger(Subscriber.class);

    private CountDownLatch latch = new CountDownLatch(1);

    public CountDownLatch getLatch() {
        return latch;
    }

    @JmsListener(destination = "message-box")
    public void receive(String message) {
        LOGGER.info("received message='{}'", message);
        latch.countDown();
    }
}
