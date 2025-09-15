package com.example.ecommerce.ecommerce.core.repository.jpa;

import com.example.ecommerce.ecommerce.model.entity.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShippingJPARepository extends JpaRepository<Shipping, Long> {
}
