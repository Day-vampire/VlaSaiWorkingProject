package com.example.JobProject.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "walletsTransactions")
public class WalletTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String type;
    private String cryptocurrencyId;
    private BigDecimal amountOfCryptocurrency;
    private BigDecimal cryptocurrencyRate;
    private Date dateOfTransaction;

    @ManyToOne
    private CryptocurrencyWallet cryptocurrencyWallet;
}
