package com.example.JobProject.repository;

import com.example.JobProject.entity.NewsSource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NewsSourceRepository extends JpaRepository<NewsSource, Long> {
    Optional<NewsSource> findByName(String name);
    Optional<NewsSource> findById(Long id);
    Optional<NewsSource> findByDomen(String domen);
}
