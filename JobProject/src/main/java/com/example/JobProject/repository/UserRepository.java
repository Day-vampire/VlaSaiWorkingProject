package com.example.JobProject.repository;

import com.example.JobProject.entity.Role;
import com.example.JobProject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByLogin(String login);
    Optional<User> findById(Long id);
    List<User> findByStatus(Boolean status);
    List<User> findByRole(Role role);
}
