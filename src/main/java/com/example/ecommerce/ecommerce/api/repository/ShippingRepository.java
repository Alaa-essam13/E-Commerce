package com.example.ecommerce.ecommerce.api.repository;

import com.example.ecommerce.ecommerce.model.entity.Shipping;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingRepository {
    Shipping findByShippingId(Long shippingId);

}
