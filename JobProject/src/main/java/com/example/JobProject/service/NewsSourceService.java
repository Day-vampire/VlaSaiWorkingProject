package com.example.JobProject.service;

import com.example.JobProject.entity.NewsSource;

public interface NewsSourceService {
    NewsSource findByName(String name);
    NewsSource findById(long id);
    NewsSource findByDomen(String domen);
}
