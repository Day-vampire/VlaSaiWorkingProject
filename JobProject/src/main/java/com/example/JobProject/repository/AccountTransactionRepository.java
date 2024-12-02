package com.example.JobProject.repository;

import com.example.JobProject.entity.AccountTransaction;
import com.example.JobProject.entity.CashAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, Long> {
    Optional<AccountTransaction> findById(Long id);

    List<AccountTransaction> findByType(String type);
    List<AccountTransaction> findByTypeAndCashAccount(String type, CashAccount cashAccount);

    List<AccountTransaction> findAll();

    List<AccountTransaction> findByDateOfAccountTransaction(Date dateOfAccountTransaction);
    List<AccountTransaction> findByDateOfAccountTransactionAndCashAccount(Date dateOfAccountTransaction, CashAccount cashAccount);

}
