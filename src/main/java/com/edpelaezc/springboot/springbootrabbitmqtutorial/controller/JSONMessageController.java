package com.edpelaezc.springboot.springbootrabbitmqtutorial.controller;

import com.edpelaezc.springboot.springbootrabbitmqtutorial.dto.User;
import com.edpelaezc.springboot.springbootrabbitmqtutorial.publisher.RabbitMQJSONProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class JSONMessageController {
    private RabbitMQJSONProducer producer;


    public JSONMessageController(RabbitMQJSONProducer producer) {
        this.producer = producer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestBody User user){
        producer.sendMessage(user);
        return ResponseEntity.ok("Message sent to RabbitMQ");
    }
}
