package com.example.client.service;

import com.example.client.api_client.AccountClient;
import com.example.client.model.AccountDto;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AccountService {

    private AccountClient accountClient;

    private Long currentUser;
    public AccountService(AccountClient accountClient){ this.accountClient = accountClient; }

    public Collection<AccountDto> readAll() { return accountClient.readAll(); }

    public void create(AccountDto data) { accountClient.create(data); }

    public void setCurrentUser(Long id) {
        this.currentUser = id;
        accountClient.setCurrentAccount(id);
    }

    public boolean isCurrentUser(){ return currentUser != null; }

    public void updateCurrentUserBalance(double changeAmount) {
        //this method is shit
        var u = new AccountDto();
        u.setAccountId(currentUser);
        double currentBalance = u.getCurrentBalance();
        u.setCurrentBalance(currentBalance + changeAmount);
        accountClient.updateAccountUser(u);
    }
    public void updateCurrentUser(AccountDto accountDto) {
        accountClient.updateAccountUser(accountDto);
    }

    public AccountDto readOne(){
        return accountClient.readCurrent();
    }
}
