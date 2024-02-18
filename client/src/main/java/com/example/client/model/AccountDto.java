package com.example.client.model;

import java.time.LocalDateTime;
import java.util.Collection;

public class AccountDto {
    private Long accountid;
    private String accountNumber;
    private String accountType;
    private double currentBalance;
    private LocalDateTime dateOpened;
    private LocalDateTime dateClosed;
    private String accountStatus;
    private Collection<Long> accountholders;
    private Collection<Long> mytransactions;

    public void addTransaction(Long transactionId){
        this.mytransactions.add(transactionId);
    }

    public Collection<Long> getAccountholders() {
        return accountholders;
    }

    public void setAccountholders(Collection<Long> accountholders) {
        this.accountholders = accountholders;
    }

    public Collection<Long> getMytransactions() {
        return mytransactions;
    }

    public void setMytransactions(Collection<Long> mytransactions) {
        this.mytransactions = mytransactions;
    }

    public Long getAccountId() {
        return accountid;
    }

    public void setAccountId(Long accountId) {
        this.accountid = accountId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public LocalDateTime getDateOpened() {
        return dateOpened;
    }

    public void setDateOpened(LocalDateTime dateOpened) {
        this.dateOpened = dateOpened;
    }

    public LocalDateTime getDateClosed() {
        return dateClosed;
    }

    public void setDateClosed(LocalDateTime dateClosed) {
        this.dateClosed = dateClosed;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }
}
