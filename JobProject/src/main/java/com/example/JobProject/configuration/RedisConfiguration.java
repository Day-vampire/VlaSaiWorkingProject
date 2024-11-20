package com.example.JobProject.configuration;

import com.example.JobProject.repository.NewsSubscriptionRepository;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@EnableCaching
public class RedisConfiguration {

    private CacheManager cacheManager;

    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory, NewsSubscriptionRepository newsSubscriptionRepository) {
        RedisCacheConfiguration configuration = RedisCacheConfiguration
                .defaultCacheConfig()
                .serializeKeysWith(RedisSerializationContext
                        .SerializationPair
                        .fromSerializer(new StringRedisSerializer())
                ).serializeValuesWith(
                    RedisSerializationContext
                            .SerializationPair
                            .fromSerializer(new GenericJackson2JsonRedisSerializer())
                );

          cacheManager = RedisCacheManager.builder(redisConnectionFactory)
                .cacheDefaults(configuration)
                .build();
         return cacheManager;
    }

    @PreDestroy
    public void clearCache() {
        // Очищаем все кэши
        if (cacheManager != null) {
            cacheManager.getCacheNames().forEach(cacheName -> {
                cacheManager.getCache(cacheName).clear();
            });
        }
    }
}
