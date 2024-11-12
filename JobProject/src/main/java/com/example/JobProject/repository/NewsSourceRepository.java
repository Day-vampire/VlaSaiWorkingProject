package com.example.JobProject.repository;

import com.example.JobProject.entity.NewsSource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsSourceRepository extends JpaRepository<NewsSource, Long> {
    NewsSource findByName(String name);
    NewsSource findById(long id);
    NewsSource findByDomen(String domen);

}
