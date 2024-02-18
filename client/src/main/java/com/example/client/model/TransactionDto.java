package com.example.client.model;

import java.time.LocalDateTime;

public class TransactionDto {

    private Long transactionId;
    private String transactionType;
    private double amount;
    private LocalDateTime transactionDate;
    private Long clientAccount;

    public Long getClientAccount() {
        return clientAccount;
    }

    public void setClientAccount(Long clientAccount) {
        this.clientAccount = clientAccount;
    }


    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }
}
