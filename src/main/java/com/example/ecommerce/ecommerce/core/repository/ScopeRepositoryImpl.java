package com.example.ecommerce.ecommerce.core.repository;

import com.example.ecommerce.ecommerce.api.repository.ScopeRepository;
import com.example.ecommerce.ecommerce.core.repository.jpa.ScopeJPARepository;
import com.example.ecommerce.ecommerce.model.entity.Scope;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class ScopeRepositoryImpl implements ScopeRepository {
    private final ScopeJPARepository scopeJPARepository;
    @Override
    public Optional<Scope> findById(Integer id) {
        return scopeJPARepository.findById(id);
    }

    @Override
    public List<Scope> getAllScopes() {
        return List.of();
    }
}
