package com.example.JobProject.repository;

import com.example.JobProject.entity.CryptocurrencyWallet;
import com.example.JobProject.entity.WalletTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface WalletTransactionRepository extends JpaRepository<WalletTransaction, Long> {
    @Override
    List<WalletTransaction> findAll();
    Optional<WalletTransaction> findById(Long id);
    List<WalletTransaction> findByTransactionDateAndWalletId(Date transactionDate, Long cryptocurrencyWalletId );
    List<WalletTransaction> findByWalletId(Long walletId);
    List<WalletTransaction> findByType(String typeOfTransaction);
}