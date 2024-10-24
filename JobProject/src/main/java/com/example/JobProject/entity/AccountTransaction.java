package com.example.JobProject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="accountTransactions")
@Getter
@Setter
public class AccountTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String currencyId;
    private BigDecimal amount;
    private BigDecimal currencyRate;
    private Date transactionDate;
}
