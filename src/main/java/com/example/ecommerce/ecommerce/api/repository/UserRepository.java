package com.example.ecommerce.ecommerce.api.repository;

import com.example.ecommerce.ecommerce.model.entity.User;

import java.util.Optional;


public interface UserRepository {
    Optional<User> findById(Long id);
    Optional<User> findByEmail(String email);
    void addUser(User user);
    void updateUser(User user);
}
