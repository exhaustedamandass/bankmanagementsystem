package com.example.tjv_project.services;

import com.example.tjv_project.entities.Account;
import com.example.tjv_project.repositories.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class AccountService extends  CrudService<Account, Long, AccountRepository>{
    public AccountService(AccountRepository repository) {
        super(repository);
    }

    public Collection<Account> readAllActive(Long numberTransactions){
        return repository.findAllMoreTransactionsThan(numberTransactions);
    }
}
