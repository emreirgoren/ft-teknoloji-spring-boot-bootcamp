package com.patika.bloghubpaymentservice.repository;

import com.patika.bloghubpaymentservice.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Long> {





    /*
    private List<Payment> paymentList = new ArrayList<>();

    public void save(Payment payment) {
        paymentList.add(payment);
    }

    public List<Payment> findAll() {
        return paymentList;
    }

    */
}
