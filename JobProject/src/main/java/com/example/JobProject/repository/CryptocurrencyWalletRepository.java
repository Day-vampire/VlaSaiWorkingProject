package com.example.JobProject.repository;

import com.example.JobProject.entity.CryptocurrencyWallet;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CryptocurrencyWalletRepository extends JpaRepository<CryptocurrencyWallet, Long> {
   CryptocurrencyWallet findByUserId(Long userId);
   List<CryptocurrencyWallet> findByStatus(Boolean status);
   List<CryptocurrencyWallet> findByAutoTradingStatus(Boolean autoTradingStatus);
}
