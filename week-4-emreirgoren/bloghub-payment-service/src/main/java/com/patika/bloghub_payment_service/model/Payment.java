package com.patika.bloghub_payment_service.model;


import jakarta.persistence.*;
import lombok.*;


import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "payments")
public class Payment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "created_date")
    private LocalDateTime createdDateTime;

    @Column(name = "payment_status")
    private PaymentStatus paymentStatus;

    @Column(name="email")
    private String email;

    public Payment(BigDecimal amount, LocalDateTime createdDateTime,PaymentStatus paymentStatus,String email){
        this.amount=amount;
        this.createdDateTime=createdDateTime;
        this.paymentStatus=paymentStatus;
        this.email=email;
    }

}
