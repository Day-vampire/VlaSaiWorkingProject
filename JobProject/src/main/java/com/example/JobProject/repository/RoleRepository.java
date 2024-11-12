package com.example.JobProject.repository;

import com.example.JobProject.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
    Role findById(long id);
    List<Role> findAll();
}
