package com.example.JobProject.service.impl;


import com.example.JobProject.entity.CryptocurrencyOld;
import com.example.JobProject.repository.CryptocurrencyRepository;
import com.example.JobProject.service.CryptocurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CryptocurrencyServiceImpl implements CryptocurrencyService {
    private final CryptocurrencyRepository cryptocurrencyRepository;

    @Override
    public List<CryptocurrencyOld> getAllCryptocurrencies() {
        return cryptocurrencyRepository.findAll();
    }

    @Override
    public CryptocurrencyOld createCurrency(String title, String description) {
        return this.cryptocurrencyRepository.save(new CryptocurrencyOld(null, title,description));
    }

    @Override
    public Optional<CryptocurrencyOld> findCryptocurrencyById(int cryptocurrencyId) {
        return this.cryptocurrencyRepository.findById(cryptocurrencyId);
    }

    @Override
    public void updateCryptocurrency(Integer id, String title, String description) {
        this.cryptocurrencyRepository.findById(id)
                .ifPresentOrElse(cryptocurrency -> {
                    cryptocurrency.setTitle(title);
                    cryptocurrency.setDescription(description);
                    },()-> {
                    throw new NoSuchElementException("Cryptocurrency not found in  CryptocurrencyServiceImpl updateCryptocurrency method"); } );
    }

    @Override
    public void deleteCryptocurrency(Integer id) {
        this.cryptocurrencyRepository.deleteById(id);}
}
