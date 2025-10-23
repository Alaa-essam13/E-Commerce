package com.example.ecommerce.ecommerce.core.repository;

import com.example.ecommerce.ecommerce.api.repository.RoleRepository;
import com.example.ecommerce.ecommerce.core.repository.jpa.RoleJPARepository;
import com.example.ecommerce.ecommerce.model.entity.Role;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class RoleRepositoryImpl implements RoleRepository {
    private final RoleJPARepository roleJPARepository;
    @Override
    public List<Role> findAll() {
        return roleJPARepository.findAll();
    }

    @Override
    public Optional<Role> findById(Integer id) {
        return roleJPARepository.findById(id);
    }

    @Override
    public void updateRole(Role role) {
        role.setUpdatedAt(LocalDateTime.now());
        roleJPARepository.save(role);
    }

    @Override
    public void deleteRole(Role role) {
        roleJPARepository.delete(role);
    }

    @Override
    public void createRole(Role role) {
        role.setCreatedAt(LocalDateTime.now());
        roleJPARepository.save(role);
    }

}
