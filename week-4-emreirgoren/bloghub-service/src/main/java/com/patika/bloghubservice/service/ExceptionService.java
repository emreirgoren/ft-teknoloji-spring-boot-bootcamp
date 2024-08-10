package com.patika.bloghubservice.service;

import com.patika.bloghubservice.model.ExceptionLog;
import com.patika.bloghubservice.repository.ExceptionLogRepository;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ExceptionService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ExceptionLogRepository exceptionLogRepository;

    public ExceptionService(KafkaTemplate<String, String> kafkaTemplate, ExceptionLogRepository exceptionLogRepository) {
        this.kafkaTemplate = kafkaTemplate;
        this.exceptionLogRepository = exceptionLogRepository;
    }

    public void logException(Exception e) {
        String exceptionMessage = e.getMessage();
        kafkaTemplate.send("exception_logs", exceptionMessage);

        ExceptionLog log = new ExceptionLog();
        log.setException(exceptionMessage);
        exceptionLogRepository.save(log);
    }
}