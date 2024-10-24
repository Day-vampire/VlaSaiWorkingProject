package com.example.JobProject.repository;


import com.example.JobProject.entity.CryptocurrencyOld;

import java.util.List;
import java.util.Optional;

public interface CryptocurrencyRepository {
    List<CryptocurrencyOld> findAll();

    CryptocurrencyOld save(CryptocurrencyOld cryptocurrency);

    Optional<CryptocurrencyOld> findById(Integer cryptocurrencyId);

    void deleteById(Integer id);
}
