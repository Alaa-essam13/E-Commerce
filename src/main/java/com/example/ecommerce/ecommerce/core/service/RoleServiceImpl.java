package com.example.ecommerce.ecommerce.core.service;

import com.example.ecommerce.ecommerce.api.repository.RoleRepository;
import com.example.ecommerce.ecommerce.api.repository.RoleScopeRepository;
import com.example.ecommerce.ecommerce.api.repository.ScopeRepository;
import com.example.ecommerce.ecommerce.api.service.RoleService;
import com.example.ecommerce.ecommerce.lib.error.AppException;
import com.example.ecommerce.ecommerce.mapper.GeneralMapper;
import com.example.ecommerce.ecommerce.model.dto.RoleDTO;
import com.example.ecommerce.ecommerce.model.dto.RoleUpdateDTO;
import com.example.ecommerce.ecommerce.model.entity.Role;
import com.example.ecommerce.ecommerce.model.entity.RoleScope;
import com.example.ecommerce.ecommerce.model.entity.Scope;
import com.example.ecommerce.ecommerce.model.vto.RoleResultSet;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.ecommerce.ecommerce.lib.error.Error.ROLE_NOT_FOUND;
import static com.example.ecommerce.ecommerce.lib.error.Error.SCOPE_NOT_FOUND;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    private final ScopeRepository scopeRepository;
    private final RoleScopeRepository roleScopeRepository;
    private final GeneralMapper mapper;
    @Override
    public RoleResultSet getAllRoles() {
        List<Role> roles=roleRepository.findAll();

        return mapper.toRoleResultSet(roles,5);
    }

    @Override
    public void createRole(RoleDTO roleDTO) {
        Role role=mapper.toRole(roleDTO);
        roleRepository.createRole(role);
    }

    @Override
    public void updateRole(Integer id, RoleUpdateDTO roleUpdateDTO) {
        Role role=roleRepository.findById(id).orElseThrow(()->new AppException(ROLE_NOT_FOUND));
        role.setTitleAr(roleUpdateDTO.getTitleAr());
        role.setTitleEn(roleUpdateDTO.getTitleEn());
        roleRepository.updateRole(role);
    }

    @Override
    public void deleteRole(Integer id) {
        Role role=roleRepository.findById(id).orElseThrow(()->new AppException(ROLE_NOT_FOUND));
        roleRepository.deleteRole(role);
    }

    @Override
    public void assignScopeToRole(Integer roleId, Integer scopeId) {
        Role role=roleRepository.findById(roleId).orElseThrow(()->new AppException(ROLE_NOT_FOUND));
        Scope scope = scopeRepository.findById(scopeId).orElseThrow(()->new AppException(SCOPE_NOT_FOUND));
        roleScopeRepository.assignRoleScope(RoleScope.builder().scope(scope).role(role).build());
    }
}
