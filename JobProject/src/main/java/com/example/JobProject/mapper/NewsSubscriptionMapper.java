package com.example.JobProject.mapper;

import com.example.JobProject.dto.NewsSubscriptionDto;
import com.example.JobProject.entity.NewsSubscription;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


@Mapper(componentModel = "spring")
public interface NewsSubscriptionMapper {
    @Mappings({
            @Mapping(source = "user.id", target = "userId"),
            @Mapping(source = "newsSource.id", target = "newsSourceId")
    })
    NewsSubscriptionDto toNewsSubscriptionDto(NewsSubscription newsSubscription);

    NewsSubscription toNewsSubscription(NewsSubscriptionDto newsSubscriptionDto);
}
