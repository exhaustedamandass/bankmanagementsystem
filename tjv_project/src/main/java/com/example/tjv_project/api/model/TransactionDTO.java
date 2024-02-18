package com.example.tjv_project.api.model;

import com.example.tjv_project.entities.Account;
import com.example.tjv_project.entities.Transaction;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TransactionDTO {
    private Long transactionId;
    private String transactionType;
    private double amount;
    private LocalDateTime transactionDate;
    private Long clientAccount;

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

    public Long getClientAccount() {
        return clientAccount;
    }

    public void setClientAccount(Long clientAccount) {
        this.clientAccount = clientAccount;
    }
}
