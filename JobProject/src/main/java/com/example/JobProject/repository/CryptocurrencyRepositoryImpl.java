package com.example.JobProject.repository;

import com.example.JobProject.entity.CryptocurrencyOld;
import com.example.JobProject.entity.CryptocurrencyOld;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.IntStream;

@Repository
public class CryptocurrencyRepositoryImpl implements CryptocurrencyRepository {
    private final List<CryptocurrencyOld> cryptocurrencyList = Collections.synchronizedList( new LinkedList<>());

    @Override
    public List<CryptocurrencyOld> findAll() {
        return Collections.unmodifiableList(cryptocurrencyList); // не модефицируемая копия листа
    }

    @Override
    public CryptocurrencyOld save(CryptocurrencyOld cryptocurrency) {
        cryptocurrency.setId(this.cryptocurrencyList.stream()
                .max(Comparator.comparingInt(CryptocurrencyOld::getId))
                .map(CryptocurrencyOld::getId)
                .orElse(0)+1);
        cryptocurrencyList.add(cryptocurrency);
        return cryptocurrency;
    }

    @Override
    public Optional<CryptocurrencyOld> findById(Integer cryptocurrencyId) {
        return this.cryptocurrencyList.stream()
                .filter(cryptocurrency -> Objects.equals(cryptocurrency.getId(),cryptocurrencyId))
                .findFirst();
    }

    @Override
    public void deleteById(Integer id) {
        this.cryptocurrencyList.removeIf(cryptocurrency -> Objects.equals(cryptocurrency.getId(),id));
    }
}
