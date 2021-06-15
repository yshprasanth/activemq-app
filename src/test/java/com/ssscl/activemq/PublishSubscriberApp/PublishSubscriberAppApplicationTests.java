package com.ssscl.activemq.PublishSubscriberApp;

import com.ssscl.activemq.PublishSubscriberApp.domain.Message;
import com.ssscl.activemq.PublishSubscriberApp.service.Publisher;
import com.ssscl.activemq.PublishSubscriberApp.service.Subscriber;
import org.apache.activemq.junit.EmbeddedActiveMQBroker;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
class PublishSubscriberAppApplicationTests {

	@Rule
	public EmbeddedActiveMQBroker broker = new EmbeddedActiveMQBroker();

	@Autowired
	private Publisher publisher;

	@Autowired
	private Subscriber subscriber;

	@Test
	public void testPublish() throws Exception {
		publisher.send(new Message("@ssscl_admin", "Hello world!!"));

		subscriber.getLatch().await(10000, TimeUnit.MILLISECONDS);
		assertThat(subscriber.getLatch().getCount()).isEqualTo(0);
	}
}
