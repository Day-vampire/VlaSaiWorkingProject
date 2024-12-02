package com.example.JobProject.service;

import com.example.JobProject.dto.NewsSubscriptionDto;
import com.example.JobProject.entity.NewsSubscription;

import java.util.List;

public interface NewsSubscriptionService {
    List<NewsSubscriptionDto> findByNewsSourceId(Long newsSourceId);
    List<NewsSubscriptionDto> findByUserId(Long userId);
    List<NewsSubscriptionDto> findByNewsSourceIdAndUserId(Long newsSourceId, Long userId);
}
