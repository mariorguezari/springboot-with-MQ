package com.mariorguezari.springbootmqsenderreceiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
 
@Component
public class Subscriber {
 
    private static final Logger LOGGER = LoggerFactory.getLogger(Subscriber.class);
 
    @Autowired
    Queue queue;
 
    @RabbitListener(queues = "#{queue.getName()}") 
    public void receive(final String message) {
        LOGGER.info("Listening MQ messages");
        LOGGER.info("Received: " + message);
        LOGGER.info("Message received!");
    }
}