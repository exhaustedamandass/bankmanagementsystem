package com.example.tjv_project.mappers;

import com.example.tjv_project.api.model.TransactionDTO;
import com.example.tjv_project.entities.Account;
import com.example.tjv_project.entities.Transaction;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class TransactionMapperUnitTest {

    @Mock
    private Transaction transaction;

    @Mock
    private Account clientAccount;

    @InjectMocks
    private TransactionMapper transactionMapper;

    @Test
    void testMapToDTO() {
        // Arrange
        MockitoAnnotations.openMocks(this); // Initialize mocks

        when(transaction.getTransactionid()).thenReturn(1L);
        when(transaction.getTransactiontype()).thenReturn("Credit");
        when(transaction.getAmount()).thenReturn(500.0);
        when(transaction.getTransactiondate()).thenReturn(LocalDateTime.of(2022, 1, 1, 12, 0));
        when(transaction.getClientaccount()).thenReturn(clientAccount);
        when(clientAccount.getAccountid()).thenReturn(101L);

        // Act
        TransactionDTO transactionDTO = transactionMapper.mapToDTO(transaction);

        // Assert
        assertEquals(1L, transactionDTO.getTransactionId());
        assertEquals("Credit", transactionDTO.getTransactionType());
        assertEquals(500.0, transactionDTO.getAmount());
        assertEquals(LocalDateTime.of(2022, 1, 1, 12, 0), transactionDTO.getTransactionDate());
        assertEquals(101L, transactionDTO.getClientAccount());
    }
}
