package com.patika.bloghubpaymentservice.model;

import com.patika.bloghubpaymentservice.dto.request.PaymentRequest;
import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "payments")
public class Payment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;
    private LocalDateTime createdDateTime;
    private PaymentStatus paymentStatus;
    private String email;

    public Payment(BigDecimal amount, LocalDateTime now, PaymentRequest paymentRequest, String email) {

    }

}
