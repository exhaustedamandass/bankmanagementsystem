package com.example.tjv_project.controllers;
import com.example.tjv_project.api.model.AccountDTO;
import com.example.tjv_project.entities.Account;
import com.example.tjv_project.entities.Transaction;
import com.example.tjv_project.services.AccountService;
import com.example.tjv_project.services.TransactionService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@SpringBootTest
public class AccountControllerFunctionalTest {

    @Mock
    private AccountService accountService;

    @Mock
    private TransactionService transactionService;

    @InjectMocks
    private AccountController accountController;

    @Test
    public void testUpdateAccount() {
        Long accountId = 1L;
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setCurrentBalance(100.0);
        accountDTO.setMytransactions(Arrays.asList(1L, 2L, 3L));

        Account existingAccount = new Account();
        existingAccount.setId(accountId);

        when(accountService.readById(accountId)).thenReturn(Optional.of(existingAccount));
        when(transactionService.readById(1L)).thenReturn(Optional.of(new Transaction()));
        when(transactionService.readById(2L)).thenReturn(Optional.of(new Transaction()));
        when(transactionService.readById(3L)).thenReturn(Optional.of(new Transaction()));

        accountController.update(accountId, accountDTO);

        verify(accountService, times(1)).update(eq(accountId), any(Account.class));
    }

    @Test
    public void testUpdateAccountNotFound() {
        Long accountId = 1L;
        AccountDTO accountDTO = new AccountDTO();

        when(accountService.readById(accountId)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> accountController.update(accountId, accountDTO));

        verify(accountService, never()).update(anyLong(), any(Account.class));
    }
}
