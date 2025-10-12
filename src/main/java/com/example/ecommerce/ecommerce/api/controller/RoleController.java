package com.example.ecommerce.ecommerce.api.controller;

import com.example.ecommerce.ecommerce.model.dto.RoleDTO;
import com.example.ecommerce.ecommerce.model.dto.RoleUpdateDTO;
import com.example.ecommerce.ecommerce.model.vto.RoleResultSet;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@Validated
public interface RoleController {
    @GetMapping
    ResponseEntity<RoleResultSet> getAllRoles();

    @PostMapping(produces = {"application/json"})
    ResponseEntity<Void> createRole(@Valid @RequestBody RoleDTO roleDTO);

    @PostMapping(path = "/{id}",produces = {"application/json"})
    ResponseEntity<Void> updateRole(@PathVariable("id") Long id, @Valid @RequestBody RoleUpdateDTO  roleUpdateDTO);

    @DeleteMapping(path = "/{id}",produces = {"application/json"})
    ResponseEntity<Void> deleteRole(@PathVariable("id") Long id);


}
