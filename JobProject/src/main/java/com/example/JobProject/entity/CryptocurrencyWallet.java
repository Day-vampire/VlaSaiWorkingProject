package com.example.JobProject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="cryptocurrenciesWallets")
@Getter
@Setter
public class CryptocurrencyWallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String currencyId;
    private boolean status;
    @OneToOne
    private User user;

    @OneToMany
    private List<CryptocurrencyActive> cryptocurrencyActive;

    @OneToMany
    private List<WalletTransaction> cryptocurrencyWallet;
}
