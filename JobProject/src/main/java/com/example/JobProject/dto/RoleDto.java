package com.example.JobProject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@Data
//@RedisHash ("roles")
@Getter
@Setter
public class RoleDto {

    private Long id;

    private String name;
}
