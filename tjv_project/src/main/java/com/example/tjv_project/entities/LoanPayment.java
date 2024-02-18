package com.example.tjv_project.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class LoanPayment {
    @Id
    private Long loanPaymentId;
    private LocalDateTime scheduledPaymentDate;
    private float paymentAmount;
    private float principalAmount;
    private float interestAmount;
    private float paidAmount;
    private LocalDateTime paidDate;
}
