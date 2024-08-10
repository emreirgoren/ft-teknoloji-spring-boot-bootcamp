
package com.patika.bloghub_payment_service.producer;

import com.patika.bloghub_payment_service.config.RabbitMQConfig;
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