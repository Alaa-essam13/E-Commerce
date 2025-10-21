package com.example.ecommerce.ecommerce.core.service;

import com.example.ecommerce.ecommerce.api.service.RoleService;
import com.example.ecommerce.ecommerce.model.dto.RoleDTO;
import com.example.ecommerce.ecommerce.model.dto.RoleUpdateDTO;
import com.example.ecommerce.ecommerce.model.vto.RoleResultSet;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {
    @Override
    public RoleResultSet getAllRoles() {
        return null;
    }

    @Override
    public void createRole(RoleDTO roleDTO) {

    }

    @Override
    public void updateRole(Long id, RoleUpdateDTO roleUpdateDTO) {

    }

    @Override
    public void deleteRole(Long id) {

    }
}
