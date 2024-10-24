package com.example.JobProject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name="cashAccounts")
@Getter
@Setter
public class CashAccount {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String currencyId;
    private BigDecimal balance;
    @OneToOne
    private User user;
    @OneToMany
    private List<AccountReport> accountReports;

    @OneToMany
    private List<AccountTransaction> accountTransactions;
}
