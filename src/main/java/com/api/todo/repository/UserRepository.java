package com.api.todo.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.api.todo.model.User;


public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    // Optional -> representa um valor que pode estar presente ou ausente.
    boolean existsByUsername(String Username);
}
