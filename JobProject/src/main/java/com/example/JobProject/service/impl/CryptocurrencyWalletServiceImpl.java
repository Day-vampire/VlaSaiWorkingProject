package com.example.JobProject.service.impl;

import com.example.JobProject.dto.CryptocurrencyWalletDto;
import com.example.JobProject.entity.User;
import com.example.JobProject.mapper.CryptocurrencyWalletMapper;
import com.example.JobProject.repository.CryptocurrencyWalletRepository;
import com.example.JobProject.service.CryptocurrencyWalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CryptocurrencyWalletServiceImpl implements CryptocurrencyWalletService {
    private final CryptocurrencyWalletRepository cryptocurrencyWalletRepository;
    private final CryptocurrencyWalletMapper cryptocurrencyWalletMapper;

    @Override
    public CryptocurrencyWalletDto findByUser(User user) {
        return cryptocurrencyWalletRepository
                .findByUser(user)
                .map(cryptocurrencyWalletMapper::toCryptocurrencyWalletDto)
                .orElse(null);
    }

    @Override
    public List<CryptocurrencyWalletDto> findByStatus(Boolean status) {
        return cryptocurrencyWalletRepository
                .findByStatus(status)
                .stream()
                .map(cryptocurrencyWalletMapper::toCryptocurrencyWalletDto)
                .toList();
    }

    @Override
    public List<CryptocurrencyWalletDto> findByStatusAndUser(Boolean status, User user) {
        return cryptocurrencyWalletRepository
                .findByStatusAndUser(status, user)
                .stream()
                .map(cryptocurrencyWalletMapper::toCryptocurrencyWalletDto)
                .toList();
    }

    @Override
    public List<CryptocurrencyWalletDto> findByAutoTradingStatus(Boolean autoTradingStatus) {
        return cryptocurrencyWalletRepository
                .findByAutoTradingStatus(autoTradingStatus)
                .stream()
                .map(cryptocurrencyWalletMapper::toCryptocurrencyWalletDto)
                .toList();
    }
}
