package com.example.ecommerce.ecommerce.api.service;

import com.example.ecommerce.ecommerce.model.dto.RoleDTO;
import com.example.ecommerce.ecommerce.model.dto.RoleUpdateDTO;
import com.example.ecommerce.ecommerce.model.vto.RoleResultSet;

public interface RoleService {

    RoleResultSet getAllRoles();

    void createRole(RoleDTO roleDTO);

    void updateRole(Long id, RoleUpdateDTO roleUpdateDTO);

    void deleteRole(Long id);
}
