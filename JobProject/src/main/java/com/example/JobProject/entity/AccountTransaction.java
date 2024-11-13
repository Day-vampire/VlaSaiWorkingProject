package com.example.JobProject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="account_transactions")
@Getter
@Setter
public class AccountTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String currencyId;
    private BigDecimal amountOfCryptocurrency;
    private BigDecimal currencyRate;
    private Date dateOfAccountTransaction;

    @ManyToOne
    @JoinColumn(name="cash_account_id")
    private CashAccount cashAccount;
}
