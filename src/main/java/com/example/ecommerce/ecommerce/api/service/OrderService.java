package com.example.ecommerce.ecommerce.api.service;

import com.example.ecommerce.ecommerce.model.dto.OrderDTO;
import com.example.ecommerce.ecommerce.model.vto.OrderVTO;
import com.example.ecommerce.ecommerce.model.vto.PagedOrderResponseVTO;

public interface OrderService {
    PagedOrderResponseVTO getAllOrders();

    OrderVTO getOrderById(Long id);

    void addOrder(OrderDTO orderDTO);
}
