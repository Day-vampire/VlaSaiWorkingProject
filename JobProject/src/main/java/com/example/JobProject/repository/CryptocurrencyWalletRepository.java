package com.example.JobProject.repository;

import com.example.JobProject.entity.CryptocurrencyWallet;
import com.example.JobProject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface CryptocurrencyWalletRepository extends JpaRepository<CryptocurrencyWallet, Long> {

   Optional<CryptocurrencyWallet> findByUser(User user);

   List<CryptocurrencyWallet> findByStatus(Boolean status);
   List<CryptocurrencyWallet> findByStatusAndUser(Boolean status, User user);

   List<CryptocurrencyWallet> findByAutoTradingStatus(Boolean autoTradingStatus);

}
