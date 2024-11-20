package com.example.JobProject.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class AccountTransactionDto {
    private Long id;
    private String type;
    private String currencyId;
    private BigDecimal amountOfCryptocurrency;
    private BigDecimal currencyRate;
    private Date dateOfAccountTransaction;
    private Long cashAccountId;
}
