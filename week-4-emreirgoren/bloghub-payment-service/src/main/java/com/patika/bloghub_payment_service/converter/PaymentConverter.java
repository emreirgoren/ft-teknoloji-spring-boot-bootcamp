package com.patika.bloghub_payment_service.converter;

import com.patika.bloghub_payment_service.dto.request.PaymentRequest;
import com.patika.bloghub_payment_service.dto.response.PaymentResponse;
import com.patika.bloghub_payment_service.model.Payment;
import com.patika.bloghub_payment_service.model.PaymentStatus;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PaymentConverter {


    public static Payment toEntity(PaymentRequest paymentRequest, PaymentStatus paymentStatus){
        return new Payment(paymentRequest.getAmount(),LocalDateTime.now(),paymentStatus,paymentRequest.getEmail());
    }

    public static PaymentResponse toResponse(Payment payment) {
        return PaymentResponse.builder()
                .amount(payment.getAmount())
                .createdDateTime(payment.getCreatedDateTime())
                .email(payment.getEmail())
                .paymentStatus(payment.getPaymentStatus())
                .build();
    }

    public static List<PaymentResponse> toResponse(List<Payment> payments) {
        return payments.stream()
                .map(PaymentConverter::toResponse)
                .toList();
    }
}
