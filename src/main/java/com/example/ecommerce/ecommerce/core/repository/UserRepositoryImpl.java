package com.example.ecommerce.ecommerce.core.repository;

import com.example.ecommerce.ecommerce.api.repository.UserRepository;
import com.example.ecommerce.ecommerce.core.repository.jpa.UserJPARepository;
import com.example.ecommerce.ecommerce.model.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private final UserJPARepository userJPARepository;
    @Override
    public Optional<User> findById(Long id) {
        return userJPARepository.findById(id);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userJPARepository.findUserByEmail(email);
    }

    @Override
    public void addUser(User user) {
        userJPARepository.save(user);
    }

    @Override
    public void updateUser(User user) {

    }


}
