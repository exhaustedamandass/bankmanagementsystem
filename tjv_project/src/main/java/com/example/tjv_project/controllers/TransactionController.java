package com.example.tjv_project.controllers;

import com.example.tjv_project.api.model.TransactionDTO;
import com.example.tjv_project.entities.Account;
import com.example.tjv_project.entities.Transaction;
import com.example.tjv_project.mappers.TransactionMapper;
import com.example.tjv_project.repositories.TransactionRepository;
import com.example.tjv_project.services.AccountService;
import com.example.tjv_project.services.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/transaction")
public class TransactionController extends CrudController<Transaction, Long, TransactionService, TransactionRepository>{
    protected TransactionService transactionService;
    protected AccountService accountService;

    private TransactionMapper transactionMapper;

    public TransactionController(TransactionService service, TransactionService transactionService, AccountService accountService, TransactionMapper transactionMapper) {
        super(service);
        this.transactionService = transactionService;
        this.accountService = accountService;
        this.transactionMapper = transactionMapper;
    }


    @PostMapping("/dto")
    @ResponseBody
    public Transaction create(@RequestBody TransactionDTO data){
        Transaction newTransaction = new Transaction();
        var optE = accountService.readById(data.getClientAccount());
        if (!optE.isPresent()) {
            throw new RuntimeException();
        }
        Account account  = optE.get();
        newTransaction.setAmount(data.getAmount());
        newTransaction.setClientaccount(account);
        newTransaction.setTransactiondate(data.getTransactionDate());
        newTransaction.setTransactiontype(data.getTransactionType());
        return transactionService.create(newTransaction);
    }

    @GetMapping("/dto")
    @ResponseBody
    public Iterable<TransactionDTO> readAllDto() {
        Iterable<Transaction> transactions = service.readAll();
        TransactionMapper mapper = new TransactionMapper(); // Instantiate the mapper
        return StreamSupport.stream(transactions.spliterator(), false)
                .map(mapper::mapToDTO)
                .collect(Collectors.toList());
    }
}
