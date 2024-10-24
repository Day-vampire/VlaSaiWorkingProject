package com.example.JobProject.entity;

import jakarta.persistence.*;

@Entity
@Table(name="favoriteCryptocurrencies")
public class FavoriteCryptocurrency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cryptocurrencyId;
    @ManyToOne
    private User user;
}
