package com.example.ecommerce.ecommerce.core.service;

import com.example.ecommerce.ecommerce.api.service.OrderService;
import com.example.ecommerce.ecommerce.model.vto.OrderVTO;
import com.example.ecommerce.ecommerce.model.vto.PagedOrderResponseVTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    @Override
    public PagedOrderResponseVTO getAllOrders() {
        return null;
    }

    @Override
    public OrderVTO getOrderById(Long id) {
        return null;
    }
}
