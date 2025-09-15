package com.example.ecommerce.ecommerce.core.repository;

import com.example.ecommerce.ecommerce.api.repository.ShippingRepository;
import com.example.ecommerce.ecommerce.core.repository.jpa.ShippingJPARepository;
import com.example.ecommerce.ecommerce.model.entity.Shipping;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class ShippingRepositoryImpl implements ShippingRepository {
    private final ShippingJPARepository shippingJPARepository;

    @Override
    public Shipping findByShippingId(Long shippingId) {
        return null;
    }
}
