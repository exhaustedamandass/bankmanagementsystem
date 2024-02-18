package com.example.tjv_project.repositories;

import com.example.tjv_project.entities.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {


    @Query(value = "SELECT a.* FROM accounts a " +
            "JOIN transactions t ON a.accountid = t.client_id " +
            "GROUP BY a.accountid " +
            "HAVING COUNT(t.transactionid) > :numberTransactions", nativeQuery = true)
    Collection<Account> findAllMoreTransactionsThan(@Param("numberTransactions") Long numberTransactions);
}
