package com.example.JobProject.repository;

import com.example.JobProject.entity.FavoriteCryptocurrency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoriteCryptocurrencyRepository extends JpaRepository<FavoriteCryptocurrency, Long> {
    List<FavoriteCryptocurrency> findByUserId(Long UserId);
    FavoriteCryptocurrency findByUserIdAndCryptocurrencyId(Long UserId, String cryptocurrencyId);

}
