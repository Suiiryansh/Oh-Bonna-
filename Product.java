package com.ecommerce.ecommerce.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double amount;

    private String status;

    public Payment() {}

    public Payment(double amount, String status) {
        this.amount = amount;
        this.status = status;
    }

    public Long getId() { return id; }

    public double getAmount() { return amount; }

    public String getStatus() { return status; }

    public void setAmount(double amount) { this.amount = amount; }

    public void setStatus(String status) { this.status = status; }
}