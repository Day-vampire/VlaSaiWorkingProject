package com.example.JobProject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.List;

@Entity
@Table (name="users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;

    private String password;

    private boolean status;

    @ManyToOne
    private Role role;

    @OneToOne
    private Person person;

    @OneToMany
    private List<NewsSubscription> newsSubscriptions;

    @OneToMany
    private List<FavoriteCryptocurrency> favoriteCryptocurrencies;

    @OneToOne
    private CashAccount cashAccount;
    @OneToOne
    private CryptocurrencyWallet cryptocurrencyWallet;
}
