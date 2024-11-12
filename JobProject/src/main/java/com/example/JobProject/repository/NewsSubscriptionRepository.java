package com.example.JobProject.repository;

import com.example.JobProject.entity.NewsSubscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewsSubscriptionRepository extends JpaRepository<NewsSubscription, Long> {
    List<NewsSubscription> findByNewsSourceId(Long newsSourceId);
    List<NewsSubscription> findByUserId(Long userId);
    List<NewsSubscription> findByNewsSourceIdAndUserId(Long newsSourceId, Long userId);
}
