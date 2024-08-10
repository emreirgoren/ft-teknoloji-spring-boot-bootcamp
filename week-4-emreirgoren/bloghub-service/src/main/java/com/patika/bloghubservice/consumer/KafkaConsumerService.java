package com.patika.bloghubservice.consumer;

import com.patika.bloghubservice.model.ExceptionLog;
import com.patika.bloghubservice.repository.ExceptionLogRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    private final ExceptionLogRepository exceptionLogRepository;

    public KafkaConsumerService(ExceptionLogRepository exceptionLogRepository) {
        this.exceptionLogRepository = exceptionLogRepository;
    }

    @KafkaListener(topics = "exception_logs", groupId = "my-group")
    public void listen(String message) {
        ExceptionLog log = new ExceptionLog();
        log.setException(message);
        exceptionLogRepository.save(log);
    }
}
