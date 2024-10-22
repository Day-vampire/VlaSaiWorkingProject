package com.example.JobProject.repository;

import com.example.JobProject.entity.Cryptocurrency;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.IntStream;

@Repository
public class CryptocurrencyRepositoryImpl implements CryptocurrencyRepository {
    private final List<Cryptocurrency> cryptocurrencyList = Collections.synchronizedList( new LinkedList<>());

    @Override
    public List<Cryptocurrency> findAll() {
        return Collections.unmodifiableList(cryptocurrencyList); // не модефицируемая копия листа
    }

    @Override
    public Cryptocurrency save(Cryptocurrency cryptocurrency) {
        cryptocurrency.setId(this.cryptocurrencyList.stream()
                .max(Comparator.comparingInt(Cryptocurrency::getId))
                .map(Cryptocurrency::getId)
                .orElse(0)+1);
        cryptocurrencyList.add(cryptocurrency);
        return cryptocurrency;
    }

    @Override
    public Optional<Cryptocurrency> findById(Integer cryptocurrencyId) {
        return this.cryptocurrencyList.stream()
                .filter(cryptocurrency -> Objects.equals(cryptocurrency.getId(),cryptocurrencyId))
                .findFirst();
    }

    @Override
    public void deleteById(Integer id) {
        this.cryptocurrencyList.removeIf(cryptocurrency -> Objects.equals(cryptocurrency.getId(),id));
    }
}
