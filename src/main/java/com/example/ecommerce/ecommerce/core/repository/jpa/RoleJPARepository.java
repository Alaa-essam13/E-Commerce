package com.example.ecommerce.ecommerce.core.repository.jpa;

import com.example.ecommerce.ecommerce.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleJPARepository extends JpaRepository<Role,Integer> {
}
