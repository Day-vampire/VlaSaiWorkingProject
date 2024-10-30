package com.example.JobProject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name="cash_accounts")
@Getter
@Setter
public class CashAccount {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String currencyId;
    private BigDecimal balance;
    private boolean status;

    @OneToOne
    @JoinColumn(name="user_id")
    private User user;

    @OneToMany(mappedBy = "cashAccount")
    private List<AccountReport> accountReports;

    @OneToMany(mappedBy = "cashAccount")
    private List<AccountTransaction> accountTransactions;
}
