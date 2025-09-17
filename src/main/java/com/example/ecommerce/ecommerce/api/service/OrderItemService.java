package com.example.ecommerce.ecommerce.api.service;

import com.example.ecommerce.ecommerce.model.dto.OrderItemDTO;
import com.example.ecommerce.ecommerce.model.dto.OrderItemUpdateRequestDTO;
import com.example.ecommerce.ecommerce.model.vto.OrderItemsVTO;

public interface OrderItemService {

    OrderItemsVTO getOrderItemsByOrderId(Long id);

    void addOrderItem(OrderItemDTO orderItemDTO);

    void updateOrderItem(OrderItemUpdateRequestDTO orderItemDTO);
}
