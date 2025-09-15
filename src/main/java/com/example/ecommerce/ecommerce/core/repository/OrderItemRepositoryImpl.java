package com.example.ecommerce.ecommerce.core.repository;

import com.example.ecommerce.ecommerce.api.repository.OrderItemRepository;
import com.example.ecommerce.ecommerce.core.repository.jpa.OrderItemJPARepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;


@Repository
@AllArgsConstructor
public class OrderItemRepositoryImpl implements OrderItemRepository {

    private final OrderItemJPARepository orderItemJPARepository;
}
