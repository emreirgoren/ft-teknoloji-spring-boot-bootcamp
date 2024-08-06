package com.patika.bloghubuserservice.listener;

import com.patika.bloghubuserservice.model.enums.StatusType;
import com.patika.bloghubuserservice.service.UserService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class EmailListener {

    private final UserService userService;

    public EmailListener(UserService userService) {
        this.userService = userService;
    }

    @RabbitListener(queues = "${rabbitmq.email.queue}")
    public void listenEmail(String email){
        userService.changeStatus(email, StatusType.APPROVED);
    }

}
