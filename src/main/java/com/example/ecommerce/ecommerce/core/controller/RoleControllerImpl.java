package com.example.ecommerce.ecommerce.core.controller;

import com.example.ecommerce.ecommerce.api.controller.RoleController;
import com.example.ecommerce.ecommerce.api.service.RoleService;
import com.example.ecommerce.ecommerce.model.dto.RoleDTO;
import com.example.ecommerce.ecommerce.model.dto.RoleUpdateDTO;
import com.example.ecommerce.ecommerce.model.vto.RoleResultSet;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("/role")
@AllArgsConstructor
public class RoleControllerImpl implements RoleController {
    private final RoleService roleService;
    @Override
    public ResponseEntity<RoleResultSet> getAllRoles() {
        return ResponseEntity.ok(roleService.getAllRoles());
    }

    @Override
    public ResponseEntity<Void> createRole(RoleDTO roleDTO) {
        roleService.createRole(roleDTO);
        return ResponseEntity.status(NO_CONTENT).build();
    }

    @Override
    public ResponseEntity<Void> updateRole(Long id, RoleUpdateDTO roleUpdateDTO) {
        roleService.updateRole(id, roleUpdateDTO);
        return ResponseEntity.status(NO_CONTENT).build();
    }

    @Override
    public ResponseEntity<Void> deleteRole(Long id) {
        roleService.deleteRole(id);
        return ResponseEntity.status(NO_CONTENT).build();
    }
}
