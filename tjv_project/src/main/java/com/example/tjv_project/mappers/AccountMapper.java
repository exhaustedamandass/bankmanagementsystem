package com.example.tjv_project.mappers;

import com.example.tjv_project.api.model.AccountDTO;
import com.example.tjv_project.entities.Account;
import com.example.tjv_project.entities.Customer;
import com.example.tjv_project.entities.Transaction;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class AccountMapper {
    public AccountDTO mapToDTO(Account account) {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountid(account.getAccountid());
        accountDTO.setAccountNumber(account.getAccountnumber());
        accountDTO.setAccountType(account.getAccounttype());
        accountDTO.setCurrentBalance(account.getCurrentbalance());
        accountDTO.setDateOpened(account.getDateopened());
        accountDTO.setDateClosed(account.getDateclosed());
        accountDTO.setAccountStatus(account.getAccountstatus());
        accountDTO.setAccountholders(getIdsFromCustomers(account.getAccountholders()));
        accountDTO.setMytransactions(getIdsFromTransactions(account.getMytransactions()));
        return accountDTO;
    }

    private static Collection<Long> getIdsFromCustomers(Collection<Customer> customers) {
        return customers.stream()
                .map(Customer::getId)
                .collect(Collectors.toList());
    }

    private static Collection<Long> getIdsFromTransactions(Collection<Transaction> transactions) {
        return transactions.stream()
                .map(Transaction::getId)
                .collect(Collectors.toList());
    }
}
