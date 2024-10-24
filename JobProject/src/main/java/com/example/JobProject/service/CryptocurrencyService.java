package com.example.JobProject.service;

import com.example.JobProject.entity.CryptocurrencyOld;

import java.util.List;
import java.util.Optional;

public interface CryptocurrencyService {

    List<CryptocurrencyOld> getAllCryptocurrencies();

    CryptocurrencyOld createCurrency(String title, String description);

    Optional <CryptocurrencyOld> findCryptocurrencyById(int cryptocurrencyId);

    void updateCryptocurrency(Integer id, String title, String description);

    void deleteCryptocurrency(Integer id);
}
