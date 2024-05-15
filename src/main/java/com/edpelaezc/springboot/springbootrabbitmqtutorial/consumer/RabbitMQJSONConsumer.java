package com.edpelaezc.springboot.springbootrabbitmqtutorial.consumer;

import com.edpelaezc.springboot.springbootrabbitmqtutorial.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQJSONConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQJSONConsumer.class);

    @RabbitListener(queues = {"${rabbitmq.queue.json.name}"})
    public void consume(User user){
        LOGGER.info(String.format("Received JSON message: %s", user.toString()));
    }
}
