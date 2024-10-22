package com.example.JobProject.service;

import com.example.JobProject.entity.Cryptocurrency;

import java.util.List;
import java.util.Optional;

public interface CryptocurrencyService {

    List<Cryptocurrency> getAllCryptocurrencies();

    Cryptocurrency createCurrency(String title, String description);

    Optional <Cryptocurrency> findCryptocurrencyById(int cryptocurrencyId);

    void updateCryptocurrency(Integer id, String title, String description);

    void deleteCryptocurrency(Integer id);
}
