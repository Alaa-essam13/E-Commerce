package com.example.ecommerce.ecommerce.api.repository;

import com.example.ecommerce.ecommerce.model.entity.RoleScope;

public interface RoleScopeRepository {
    void deleteRoleScope(RoleScope roleScope);
    void assignRoleScope(RoleScope roleScope);
}
