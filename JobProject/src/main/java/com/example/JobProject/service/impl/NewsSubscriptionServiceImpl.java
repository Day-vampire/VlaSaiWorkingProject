package com.example.JobProject.service.impl;

import com.example.JobProject.dto.NewsSubscriptionDto;
import com.example.JobProject.dto.UserDto;
import com.example.JobProject.entity.NewsSubscription;
import com.example.JobProject.entity.User;
import com.example.JobProject.exception.AlreadyExistsException;
import com.example.JobProject.exception.NotFoundException;
import com.example.JobProject.mapper.NewsSubscriptionMapper;
import com.example.JobProject.repository.NewsSourceRepository;
import com.example.JobProject.repository.NewsSubscriptionRepository;
import com.example.JobProject.repository.UserRepository;
import com.example.JobProject.service.NewsSubscriptionService;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsSubscriptionServiceImpl implements NewsSubscriptionService {

    private final NewsSubscriptionRepository newsSubscriptionRepository;
    private final NewsSourceRepository newsSourceRepository;
    private final NewsSubscriptionMapper newsSubscriptionMapper;
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<NewsSubscriptionDto> findByNewsSourceId(Long newsSourceId) {
        return newsSubscriptionRepository
                .findByNewsSourceId(newsSourceId)
                .stream()
                .map(newsSubscriptionMapper::toNewsSubscriptionDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<NewsSubscriptionDto> findByUserId(Long userId) {
        return  newsSubscriptionRepository
                .findByUserId(userId)
                .stream()
                .map(newsSubscriptionMapper::toNewsSubscriptionDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public NewsSubscriptionDto findByNewsSourceIdAndUserId(Long newsSourceId, Long userId) {
        return newsSubscriptionRepository
                .findByNewsSourceIdAndUserId(newsSourceId, userId)
                .map(newsSubscriptionMapper::toNewsSubscriptionDto)
                .orElseThrow(()-> new NotFoundException("News Subscription with SourceId %d and UserId %d not found".formatted(newsSourceId,userId)));
    }

    @Transactional(readOnly = true)
    public List<NewsSubscriptionDto> findAll() {
        return newsSubscriptionRepository
                .findAll()
                .stream()
                .map(newsSubscriptionMapper::toNewsSubscriptionDto)
                .toList();
    }

    @Transactional
    public NewsSubscriptionDto save(NewsSubscriptionDto newsSubscriptionDto) {
        Long userId = newsSubscriptionDto.getUserId();
        if (!userRepository.existsById(userId)) {
            throw new NotFoundException("User with id: %d not found".formatted(userId));
        }
        Long newsSourceId = newsSubscriptionDto.getNewsSourceId();
        if (!newsSourceRepository.existsById(newsSourceId)) {
            throw new NotFoundException("News Source with id: %d not found".formatted(newsSourceId));
        }
        if (newsSubscriptionRepository.findByNewsSourceIdAndUserId(newsSourceId, userId)!=null){
            throw new AlreadyExistsException("Subscription already exists");
        }
        newsSubscriptionRepository.save(newsSubscriptionMapper.toNewsSubscription(newsSubscriptionDto));
        return newsSubscriptionDto;
    }

    @Transactional
    public void delete(Long newsSubscriptionId) {
        newsSubscriptionRepository.deleteById(newsSubscriptionId);
    }
}
