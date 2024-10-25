package com.example.JobProject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name="cryptocurrenciesActives")
@Getter
@Setter
public class CryptocurrencyActive {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String cryptocurrencyId;
    private BigDecimal balance;
}
