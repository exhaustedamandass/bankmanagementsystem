package com.example.tjv_project.mappers;

import com.example.tjv_project.api.model.AccountDTO;
import com.example.tjv_project.entities.Account;
import com.example.tjv_project.entities.Customer;
import com.example.tjv_project.entities.Transaction;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AccountMapperUnitTest {

    @Test
    public void testMapToDTO() {
        Account account = new Account();
        account.setAccountid(1L);
        account.setAccountnumber("123456789");
        account.setAccounttype("Savings");
        account.setCurrentbalance(1000.0);
        account.setDateopened(LocalDateTime.of(2022, 1, 1, 0, 0)); // Set LocalDateTime here
        account.setDateclosed(null);
        account.setAccountstatus("Active");

        Customer customer1 = new Customer();
        customer1.setId(101L);

        Customer customer2 = new Customer();
        customer2.setId(102L);

        Transaction transaction1 = new Transaction();
        transaction1.setId(201L);

        Transaction transaction2 = new Transaction();
        transaction2.setId(202L);

        account.setAccountholders(List.of(customer1, customer2));
        account.setMytransactions(List.of(transaction1, transaction2));

        AccountMapper accountMapper = new AccountMapper();

        AccountDTO accountDTO = accountMapper.mapToDTO(account);

        assertEquals(account.getAccountid(), accountDTO.getAccountid());
        assertEquals(account.getAccountnumber(), accountDTO.getAccountNumber());
        assertEquals(account.getAccounttype(), accountDTO.getAccountType());
        assertEquals(account.getCurrentbalance(), accountDTO.getCurrentBalance());
        assertEquals(account.getDateopened(), accountDTO.getDateOpened());
        assertEquals(account.getDateclosed(), accountDTO.getDateClosed());
        assertEquals(account.getAccountstatus(), accountDTO.getAccountStatus());

        assertIterableEquals(List.of(101L, 102L), accountDTO.getAccountholders());
        assertIterableEquals(List.of(201L, 202L), accountDTO.getMytransactions());
    }
}
