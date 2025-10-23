package com.example.ecommerce.ecommerce.api.repository;

import com.example.ecommerce.ecommerce.model.entity.Scope;

import java.util.List;
import java.util.Optional;

public interface ScopeRepository {
    Optional<Scope> findById(Integer id);
    List<Scope> getAllScopes();
}
