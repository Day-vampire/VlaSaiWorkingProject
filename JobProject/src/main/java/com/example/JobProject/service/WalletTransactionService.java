package com.example.JobProject.service;

import com.example.JobProject.dto.WalletTransactionDto;


import java.util.Date;
import java.util.List;


public interface WalletTransactionService {
    List<WalletTransactionDto> findAll();
    WalletTransactionDto findById(Long id);
    List<WalletTransactionDto> findByDateOfTransactionAndCryptocurrencyWalletId(Date dateOfTransaction, Long cryptocurrencyWalletId );
    List<WalletTransactionDto> findByCryptocurrencyWalletId(Long cryptocurrencyWalletId);
    List<WalletTransactionDto> findByType(String typeOfTransaction);
}
