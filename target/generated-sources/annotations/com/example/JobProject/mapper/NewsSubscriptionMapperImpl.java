package com.example.JobProject.mapper;

import com.example.JobProject.dto.NewsSubscriptionDto;
import com.example.JobProject.entity.NewsSource;
import com.example.JobProject.entity.NewsSubscription;
import com.example.JobProject.entity.User;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-19T19:12:00+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
public class NewsSubscriptionMapperImpl implements NewsSubscriptionMapper {

    @Override
    public NewsSubscriptionDto toNewsSubscriptionDto(NewsSubscription newsSubscription) {
        if ( newsSubscription == null ) {
            return null;
        }

        NewsSubscriptionDto newsSubscriptionDto = new NewsSubscriptionDto();

        newsSubscriptionDto.setUserId( newsSubscriptionUserId( newsSubscription ) );
        newsSubscriptionDto.setNewsSourceId( newsSubscriptionNewsSourceId( newsSubscription ) );
        newsSubscriptionDto.setId( newsSubscription.getId() );
        newsSubscriptionDto.setDateOfNewsSubscription( newsSubscription.getDateOfNewsSubscription() );

        return newsSubscriptionDto;
    }

    @Override
    public NewsSubscription toNewsSubscription(NewsSubscriptionDto newsSubscriptionDto) {
        if ( newsSubscriptionDto == null ) {
            return null;
        }

        NewsSubscription newsSubscription = new NewsSubscription();

        newsSubscription.setId( newsSubscriptionDto.getId() );
        newsSubscription.setDateOfNewsSubscription( newsSubscriptionDto.getDateOfNewsSubscription() );

        return newsSubscription;
    }

    private Long newsSubscriptionUserId(NewsSubscription newsSubscription) {
        if ( newsSubscription == null ) {
            return null;
        }
        User user = newsSubscription.getUser();
        if ( user == null ) {
            return null;
        }
        Long id = user.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long newsSubscriptionNewsSourceId(NewsSubscription newsSubscription) {
        if ( newsSubscription == null ) {
            return null;
        }
        NewsSource newsSource = newsSubscription.getNewsSource();
        if ( newsSource == null ) {
            return null;
        }
        Long id = newsSource.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
