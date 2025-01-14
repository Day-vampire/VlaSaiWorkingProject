package com.example.JobProject.service;

import com.example.JobProject.dto.NewsSubscriptionDto;
import com.example.JobProject.entity.NewsSource;

import java.util.List;

public interface NewsSourceService {
    NewsSource findByName(String name);
    NewsSource findById(Long id);
    NewsSource findByDomen(String domen);
    List<NewsSource> findAll();
    NewsSource save(NewsSource newsSource);
    void delete(Long id);
}
