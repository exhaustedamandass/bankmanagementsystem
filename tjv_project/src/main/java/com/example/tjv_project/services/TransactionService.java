package com.example.tjv_project.services;

import com.example.tjv_project.entities.Transaction;
import com.example.tjv_project.repositories.TransactionRepository;
import org.springframework.stereotype.Service;

@Service
public class TransactionService extends CrudService<Transaction, Long, TransactionRepository>{
    public TransactionService(TransactionRepository repository) {
        super(repository);
    }

}


