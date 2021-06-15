package com.ssscl.activemq.PublishSubscriberApp;

import org.apache.activemq.junit.EmbeddedActiveMQBroker;
import org.junit.Rule;

public class PublishSubscriberEmbeddedMQTest {
    @Rule
    public EmbeddedActiveMQBroker broker = new EmbeddedActiveMQBroker();
}
