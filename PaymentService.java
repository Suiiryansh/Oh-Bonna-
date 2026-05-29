package com.ecommerce.ecommerce.service;

import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.entity.Payment;
import com.ecommerce.ecommerce.repository.PaymentRepository;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment makePayment(double amount) {
        Payment payment = new Payment(amount, "SUCCESS");
        return paymentRepository.save(payment);
    }
}