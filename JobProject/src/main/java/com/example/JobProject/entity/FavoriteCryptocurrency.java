package com.example.JobProject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="favorite_cryptocurrencies")
@Getter
@Setter
public class FavoriteCryptocurrency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cryptocurrencyId;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
}
