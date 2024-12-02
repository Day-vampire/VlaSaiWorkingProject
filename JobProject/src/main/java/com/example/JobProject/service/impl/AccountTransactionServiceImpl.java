package com.example.JobProject.service.impl;

import com.example.JobProject.dto.AccountTransactionDto;
import com.example.JobProject.entity.CashAccount;
import com.example.JobProject.mapper.AccountTransactionMapper;
import com.example.JobProject.repository.AccountTransactionRepository;
import com.example.JobProject.service.AccountTransactionService;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class AccountTransactionServiceImpl implements AccountTransactionService {

    private AccountTransactionRepository accountTransactionRepository;
    private AccountTransactionMapper accountTransactionMapper;


    @Override
    public AccountTransactionDto findById(Long id) {
        return accountTransactionRepository.findById(id).map(accountTransactionMapper::toAccountTransactionDto).orElse(null);
    }

    @Override
    public List<AccountTransactionDto> findByType(String type) {
        return accountTransactionRepository
                .findByType(type)
                .stream()
                .map(accountTransactionMapper::toAccountTransactionDto)
                .toList();
    }

    @Override
    public List<AccountTransactionDto> findByTypeAndCashAccount(String type, CashAccount cashAccount) {
        return accountTransactionRepository
                .findByTypeAndCashAccount(type, cashAccount)
                .stream()
                .map(accountTransactionMapper::toAccountTransactionDto)
                .toList();
    }

    @Override
    public List<AccountTransactionDto> findAll() {
        return accountTransactionRepository
                .findAll()
                .stream()
                .map(accountTransactionMapper::toAccountTransactionDto)
                .toList();
    }

    @Override
    public List<AccountTransactionDto> findByDateOfAccountTransaction(Date dateOfAccountTransaction) {
        return accountTransactionRepository
                .findByDateOfAccountTransaction(dateOfAccountTransaction)
                .stream()
                .map(accountTransactionMapper::toAccountTransactionDto)
                .toList();
    }

    @Override
    public List<AccountTransactionDto> findByDateOfAccountTransactionAndCashAccount(Date dateOfAccountTransaction, CashAccount cashAccount) {
        return accountTransactionRepository
                .findByDateOfAccountTransactionAndCashAccount(dateOfAccountTransaction, cashAccount)
                .stream()
                .map(accountTransactionMapper::toAccountTransactionDto)
                .toList();
    }
}
