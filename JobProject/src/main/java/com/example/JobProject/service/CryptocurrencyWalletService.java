package com.example.JobProject.service;

import com.example.JobProject.dto.CryptocurrencyWalletDto;
import com.example.JobProject.entity.CryptocurrencyWallet;
import com.example.JobProject.entity.User;

import java.util.List;

public interface CryptocurrencyWalletService {
    CryptocurrencyWalletDto findByUser(User user);

    List<CryptocurrencyWalletDto> findByStatus(Boolean status);
    List<CryptocurrencyWalletDto> findByStatusAndUser(Boolean status, User user);

    List<CryptocurrencyWalletDto> findByAutoTradingStatus(Boolean autoTradingStatus);
}
