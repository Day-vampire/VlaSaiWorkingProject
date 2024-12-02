package com.example.JobProject.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Getter
@Setter
public class NewsSubscriptionDto {
    private long id;
    private LocalDate dateOfNewsSubscription;
    private Long userId;
    private Long newsSourceId;
}
