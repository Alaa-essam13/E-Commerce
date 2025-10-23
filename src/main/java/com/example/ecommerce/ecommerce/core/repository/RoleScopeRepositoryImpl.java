package com.example.ecommerce.ecommerce.core.repository;

import com.example.ecommerce.ecommerce.api.repository.RoleScopeRepository;
import com.example.ecommerce.ecommerce.core.repository.jpa.RoleScopeJPARepository;
import com.example.ecommerce.ecommerce.model.entity.RoleScope;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class RoleScopeRepositoryImpl implements RoleScopeRepository {
    private final RoleScopeJPARepository roleScopeJPARepository;
    @Override
    public void deleteRoleScope(RoleScope roleScope) {
        roleScopeJPARepository.delete(roleScope);
    }

    @Override
    public void assignRoleScope(RoleScope roleScope) {
        roleScopeJPARepository.save(roleScope);
    }
}
