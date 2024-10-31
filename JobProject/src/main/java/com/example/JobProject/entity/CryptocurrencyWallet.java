package com.example.JobProject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="cryptocurrency_wallets")
@Getter
@Setter
public class CryptocurrencyWallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String currencyId;
    private boolean status;
    private boolean autoTradingStatus;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "cryptocurrencyWallet")
    private List<CryptocurrencyActive> cryptocurrencyActive;

    @OneToMany(mappedBy = "cryptocurrencyWallet")
    private List<WalletTransaction> walletTransactions;
}
