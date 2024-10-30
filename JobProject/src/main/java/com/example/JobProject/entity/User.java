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
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @OneToMany(mappedBy = "user")
    private List<NewsSubscription> newsSubscriptions;

    @OneToMany(mappedBy = "user")
    private List<FavoriteCryptocurrency> favoriteCryptocurrencies;


    @OneToOne(mappedBy = "user")
    private CashAccount cashAccount;


    @OneToOne(mappedBy = "user")
    private CryptocurrencyWallet cryptocurrencyWallet;

    @OneToMany(mappedBy = "user")
    private List<CryptocurrencyReport> cryptocurrencyReport;

}
