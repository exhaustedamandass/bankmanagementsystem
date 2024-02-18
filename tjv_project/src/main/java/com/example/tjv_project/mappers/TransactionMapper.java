package com.example.tjv_project.mappers;

import com.example.tjv_project.api.model.TransactionDTO;
import com.example.tjv_project.entities.Transaction;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper {
    public TransactionDTO mapToDTO(Transaction transaction) {
        TransactionDTO transactionDTO = new TransactionDTO();
        transactionDTO.setTransactionId(transaction.getTransactionid());
        transactionDTO.setTransactionType(transaction.getTransactiontype());
        transactionDTO.setAmount(transaction.getAmount());
        transactionDTO.setTransactionDate(transaction.getTransactiondate());
        transactionDTO.setClientAccount(transaction.getClientaccount().getAccountid());
        return transactionDTO;
    }
}
