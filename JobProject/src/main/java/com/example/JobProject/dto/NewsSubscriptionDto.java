package com.example.JobProject.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class NewsSubscriptionDto {
    private long id;
    private LocalDate dateOfNewsSubscription;
    private Long userId;
    private Long newsSourceId;
}
