package com.mariorguezari.springbootmqsenderreceiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class Publisher {
 
    private static final Logger logger = LoggerFactory.getLogger(Publisher.class);
 
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    Binding binding;
 
    @GetMapping(value = "/send/{message}")
    @ResponseStatus(code = HttpStatus.OK)
    public String send(
        @PathVariable("message") final String message
        ) {

        logger.info("Send to MQ queue: message");
        rabbitTemplate.convertAndSend(binding.getExchange(), binding.getRoutingKey(), message);
        return "Message sent to MQ!";
    }
}