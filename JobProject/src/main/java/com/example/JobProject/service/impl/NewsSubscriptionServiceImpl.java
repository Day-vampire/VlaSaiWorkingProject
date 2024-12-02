package com.example.JobProject.service.impl;

import com.example.JobProject.dto.NewsSubscriptionDto;
import com.example.JobProject.dto.UserDto;
import com.example.JobProject.entity.NewsSubscription;
import com.example.JobProject.mapper.NewsSubscriptionMapper;
import com.example.JobProject.repository.NewsSubscriptionRepository;
import com.example.JobProject.service.NewsSubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsSubscriptionServiceImpl implements NewsSubscriptionService {

    private final NewsSubscriptionRepository newsSubscriptionRepository;
    private final NewsSubscriptionMapper newsSubscriptionMapper;

    @Override
    public List<NewsSubscriptionDto> findByNewsSourceId(Long newsSourceId) {
        return newsSubscriptionRepository
                .findByNewsSourceId(newsSourceId)
                .stream()
                .map(newsSubscriptionMapper::toNewsSubscriptionDto)
                .toList();
    }

    @Override
    public List<NewsSubscriptionDto> findByUserId(Long userId) {
        return  newsSubscriptionRepository
                .findByUserId(userId)
                .stream()
                .map(newsSubscriptionMapper::toNewsSubscriptionDto)
                .toList();
    }

    @Override
    public List<NewsSubscriptionDto> findByNewsSourceIdAndUserId(Long newsSourceId, Long userId) {
        return newsSubscriptionRepository
                .findByNewsSourceIdAndUserId(newsSourceId, userId)
                .stream()
                .map(newsSubscriptionMapper::toNewsSubscriptionDto)
                .toList();
    }
}
