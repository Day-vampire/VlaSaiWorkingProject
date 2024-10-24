package com.example.JobProject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name="newsSubscriptions")
@Getter
@Setter
public class NewsSubscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date newsSubscriptiondate;
    @ManyToOne
    private User user;
    @ManyToOne
    private NewsSource newsSource;
}
