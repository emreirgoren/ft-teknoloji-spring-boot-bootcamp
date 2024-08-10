package com.patika.bloghub_payment_service.service;

import com.patika.bloghub_payment_service.converter.PaymentConverter;
import com.patika.bloghub_payment_service.dto.request.PaymentRequest;
import com.patika.bloghub_payment_service.dto.response.PaymentResponse;
import com.patika.bloghub_payment_service.model.Payment;
import com.patika.bloghub_payment_service.model.PaymentStatus;
import com.patika.bloghub_payment_service.producer.RabbitMQProducer;
import com.patika.bloghub_payment_service.repository.PaymentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final RabbitMQProducer rabbitMQProducer;

    public PaymentService(PaymentRepository paymentRepository, RabbitMQProducer rabbitMQProducer) {
        this.paymentRepository = paymentRepository;
        this.rabbitMQProducer = rabbitMQProducer;
    }


    public PaymentResponse createPayment(PaymentRequest request) {

        Payment payment = PaymentConverter.toEntity(request, PaymentStatus.PAID);

        paymentRepository.save(payment);

        rabbitMQProducer.sendEmail(payment.getEmail());

        return PaymentConverter.toResponse(payment);
    }

    public List<PaymentResponse> getAllPayments() {
        List<Payment> payments = paymentRepository.findAll();

        return PaymentConverter.toResponse(payments);
    }

}