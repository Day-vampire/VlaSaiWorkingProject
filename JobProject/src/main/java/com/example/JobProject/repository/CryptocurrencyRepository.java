package com.example.JobProject.repository;

import com.example.JobProject.entity.Cryptocurrency;

import java.util.List;
import java.util.Optional;

public interface CryptocurrencyRepository {
    List<Cryptocurrency> findAll();

    Cryptocurrency save(Cryptocurrency cryptocurrency);

    Optional<Cryptocurrency> findById(Integer cryptocurrencyId);

    void deleteById(Integer id);
}
