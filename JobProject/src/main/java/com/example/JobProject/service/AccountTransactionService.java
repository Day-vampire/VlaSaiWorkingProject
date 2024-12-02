package com.example.JobProject.service;

import com.example.JobProject.dto.AccountTransactionDto;
import com.example.JobProject.entity.AccountTransaction;
import com.example.JobProject.entity.CashAccount;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface AccountTransactionService {
    AccountTransactionDto findById(Long id);

    List<AccountTransactionDto> findByType(String type);
    List<AccountTransactionDto> findByTypeAndCashAccount(String type, CashAccount cashAccount);

    List<AccountTransactionDto> findAll();

    List<AccountTransactionDto> findByDateOfAccountTransaction(Date dateOfAccountTransaction);
    List<AccountTransactionDto> findByDateOfAccountTransactionAndCashAccount(Date dateOfAccountTransaction, CashAccount cashAccount);
}
