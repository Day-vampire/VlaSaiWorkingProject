package com.example.JobProject.service.impl;

import com.example.JobProject.dto.WalletTransactionDto;
import com.example.JobProject.entity.WalletTransaction;
import com.example.JobProject.mapper.WalletTransactionMapper;
import com.example.JobProject.repository.WalletTransactionRepository;
import com.example.JobProject.service.WalletTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WalletTransactionServiceImpl implements WalletTransactionService {
    private final WalletTransactionRepository walletTransactionRepository;
    private final WalletTransactionMapper walletTransactionMapper;

    @Override
    public List<WalletTransactionDto> findAll() {
        return walletTransactionRepository
                .findAll()
                .stream()
                .map(walletTransactionMapper::toWalletTransactionDto)
                .toList();
    }

    @Override
    public WalletTransactionDto findById(Long id) {
        return walletTransactionRepository
                .findById(id)
                .map(walletTransactionMapper::toWalletTransactionDto)
                .orElse(null);
    }

    @Override
    public List<WalletTransactionDto> findByDateOfTransactionAndCryptocurrencyWalletId(Date dateOfTransaction, Long cryptocurrencyWalletId) {
        return walletTransactionRepository
                .findByDateOfTransactionAndCryptocurrencyWalletId(dateOfTransaction, cryptocurrencyWalletId)
                .stream()
                .map(walletTransactionMapper::toWalletTransactionDto)
                .toList();
    }

    @Override
    public List<WalletTransactionDto> findByCryptocurrencyWalletId(Long cryptocurrencyWalletId) {
        return walletTransactionRepository
                .findByCryptocurrencyWalletId(cryptocurrencyWalletId)
                .stream()
                .map(walletTransactionMapper::toWalletTransactionDto)
                .toList();
    }

    @Override
    public List<WalletTransactionDto> findByType(String typeOfTransaction) {
        return walletTransactionRepository
                .findByType(typeOfTransaction)
                .stream()
                .map(walletTransactionMapper::toWalletTransactionDto)
                .toList();
    }
}
