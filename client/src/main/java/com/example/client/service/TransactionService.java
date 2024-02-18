package com.example.client.service;

import com.example.client.api_client.TransactionClient;
import com.example.client.model.TransactionDto;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class TransactionService {
    private TransactionClient transactionClient;
    private Long currentUser;

    public TransactionService(TransactionClient transactionClient) {
        this.transactionClient = transactionClient;
    }
    public Collection<TransactionDto> readAll(){return transactionClient.readAll();}

    public void create(TransactionDto data) {transactionClient.create(data);}

    public void setCurrentUser(Long id){
        this.currentUser = id;
        transactionClient.setCurrentAccount(id);
    }

    public boolean isCurrentUser(){ return currentUser != null; }

    public TransactionDto readOne() { return transactionClient.readCurrent(); }


}
