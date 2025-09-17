package com.example.ecommerce.ecommerce.core.service;

import com.example.ecommerce.ecommerce.api.repository.OrderItemRepository;
import com.example.ecommerce.ecommerce.api.repository.OrderRepository;
import com.example.ecommerce.ecommerce.api.service.OrderService;
import com.example.ecommerce.ecommerce.mapper.GeneralMapper;
import com.example.ecommerce.ecommerce.model.dto.OrderDTO;
import com.example.ecommerce.ecommerce.model.entity.Order;
import com.example.ecommerce.ecommerce.model.entity.OrderItem;
import com.example.ecommerce.ecommerce.model.vto.OrderVTO;
import com.example.ecommerce.ecommerce.model.vto.PagedOrderResponseVTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final GeneralMapper mapper;
    private final OrderItemRepository orderItemRepository;

    @Override
    public PagedOrderResponseVTO getAllOrders() {
        return null;
    }

    @Override
    public OrderVTO getOrderById(Long id) {
        Order order = orderRepository.findOrderById(id).orElseThrow();
        List<OrderItem> orderItems = orderItemRepository.findAllItemsOfOrder(id);
        return mapper.toOrderVTO(order,orderItems);
    }

    @Override
    public void addOrder(OrderDTO orderDTO) {

        Order order = mapper.toOrder(orderDTO);
        orderRepository.addOrder(order);
    }
}
