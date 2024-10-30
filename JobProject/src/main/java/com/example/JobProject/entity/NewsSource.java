package com.example.JobProject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="news_sources")
@Getter
@Setter
public class NewsSource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String domen;
    private String description;
    @OneToMany(mappedBy = "newsSource")
    private List<NewsSubscription> newsSubscriptions;

}
