package com.example.JobProject.repository;

import com.example.JobProject.dto.NewsSubscriptionDto;
import com.example.JobProject.entity.NewsSubscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NewsSubscriptionRepository extends JpaRepository<NewsSubscription, Long> {
    List<NewsSubscription> findByNewsSourceId(Long newsSourceId);
    List<NewsSubscription> findByUserId(Long userId);
    Optional<NewsSubscription> findByNewsSourceIdAndUserId(Long newsSourceId, Long userId);
    List<NewsSubscription> findAll();
}
