package com.example.JobProject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cryptocurrency {
    private Integer id;
    private String title;
    private String description;
}
