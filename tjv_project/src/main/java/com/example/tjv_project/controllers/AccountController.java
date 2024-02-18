package com.example.tjv_project.controllers;

import com.example.tjv_project.api.model.AccountDTO;
import com.example.tjv_project.entities.Account;
import com.example.tjv_project.entities.Transaction;
import com.example.tjv_project.mappers.AccountMapper;
import com.example.tjv_project.repositories.AccountRepository;
import com.example.tjv_project.services.AccountService;
import com.example.tjv_project.services.CustomerService;
import com.example.tjv_project.services.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/account")
public class AccountController extends CrudController<Account, Long, AccountService, AccountRepository>{


    protected AccountService accountService;
    protected TransactionService transactionService;
    protected CustomerService customerService;

    protected AccountMapper accountMapper;

    public AccountController(AccountService service, AccountService accountService, TransactionService transactionService, CustomerService customerService, AccountMapper accountMapper) {
        super(service);
        this.accountService = accountService;
        this.transactionService = transactionService;
        this.customerService = customerService;
        this.accountMapper = accountMapper;
    }

    @GetMapping("/active")
    public Iterable<Account> readAllOrFindAllActive(@RequestParam Long numberTransactions){
        return accountService.readAllActive(numberTransactions);
    }

    @PutMapping("/dto/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long id, @RequestBody AccountDTO data){
        var optE = accountService.readById(id);
        if(!optE.isPresent()){
            throw new RuntimeException();
        }
        Account account = optE.get();
        account.setCurrentbalance(data.getCurrentBalance());
        Collection<Transaction> updatedTransactions = new ArrayList<>();
        for(long singleTransaction : data.getMytransactions()){
            var opt2E = transactionService.readById(singleTransaction);
            if(!opt2E.isPresent()){
                throw new RuntimeException();
            }
            Transaction transaction = opt2E.get();
            updatedTransactions.add(transaction);
        }
        account.setMytransactions(updatedTransactions);
        accountService.update(id, account);
    }

    @GetMapping("/dto")
    @ResponseBody
    public Iterable<AccountDTO> readAllDto() {
        Iterable<Account> accounts = service.readAll();
        return StreamSupport.stream(accounts.spliterator(), false)
                .map(accountMapper::mapToDTO)
                .collect(Collectors.toList());
    }
    @GetMapping("/dto/{id}")
    @ResponseBody
    public ResponseEntity<AccountDTO> readByIdDTO(@PathVariable Long id) {
        Optional<Account> accountOptional = service.readById(id);
        if (accountOptional.isPresent()) {
            AccountDTO accountDTO = accountMapper.mapToDTO(accountOptional.get());
            return new ResponseEntity<>(accountDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
