package com.example.JobProject.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table (name="roles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "role")
    private List<User> user;
}
