package com.patika.bloghubpaymentservice.producer;

import com.patika.bloghubpaymentservice.config.RabbitMQConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQProducer {

    private final AmqpTemplate rabbitTemplate;

    private final RabbitMQConfig rabbitMQConfig;


    public RabbitMQProducer(AmqpTemplate rabbitTemplate, RabbitMQConfig rabbitMQConfig) {
        this.rabbitTemplate = rabbitTemplate;
        this.rabbitMQConfig = rabbitMQConfig;
    }

    public void sendEmail(String email){
        rabbitTemplate.convertAndSend(rabbitMQConfig.getExchange(),rabbitMQConfig.getRoutingkey(),email);
    }

}
