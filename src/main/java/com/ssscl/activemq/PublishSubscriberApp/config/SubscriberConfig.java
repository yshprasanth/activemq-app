package com.ssscl.activemq.PublishSubscriberApp.config;

//import com.ssscl.activemq.PublishSubscriberApp.service.Subscriber;
//import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;

@Configuration
@EnableJms
public class SubscriberConfig {

    @Autowired
    private ActiveMQConnectionFactory activeMQConnectionFactory;


    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(activeMQConnectionFactory);
        factory.setPubSubDomain(true);
        return factory;
    }
}
