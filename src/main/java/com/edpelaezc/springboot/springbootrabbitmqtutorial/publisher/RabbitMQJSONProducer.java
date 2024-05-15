package com.edpelaezc.springboot.springbootrabbitmqtutorial.publisher;

import com.edpelaezc.springboot.springbootrabbitmqtutorial.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQJSONProducer {

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.key.json}")
    private String routingKey;

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQJSONProducer.class);

    private RabbitTemplate template;

    @Autowired
    public RabbitMQJSONProducer(RabbitTemplate template) {
        this.template = template;
    }

    public void sendMessage(User user){
        LOGGER.info(String.format("User sent to RabbitMQ: %s", user.toString()));
        template.convertAndSend(exchange, routingKey, user);
    }
}
