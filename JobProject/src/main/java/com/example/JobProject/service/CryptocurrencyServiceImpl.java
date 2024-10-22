package com.example.JobProject.service;

import com.example.JobProject.entity.Cryptocurrency;
import com.example.JobProject.repository.CryptocurrencyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CryptocurrencyServiceImpl implements CryptocurrencyService {
    private final CryptocurrencyRepository cryptocurrencyRepository;

    @Override
    public List<Cryptocurrency> getAllCryptocurrencies() {
        return cryptocurrencyRepository.findAll();
    }

    @Override
    public Cryptocurrency createCurrency(String title, String description) {
        return this.cryptocurrencyRepository.save(new Cryptocurrency(null, title,description));
    }

    @Override
    public Optional<Cryptocurrency> findCryptocurrencyById(int cryptocurrencyId) {
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
