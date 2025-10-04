package com.example.ecommerce.ecommerce.core.service;

import com.example.ecommerce.ecommerce.api.repository.OrderItemRepository;
import com.example.ecommerce.ecommerce.api.repository.ProductRepository;
import com.example.ecommerce.ecommerce.api.service.OrderItemService;
import com.example.ecommerce.ecommerce.mapper.GeneralMapper;
import com.example.ecommerce.ecommerce.model.dto.OrderItemDTO;
import com.example.ecommerce.ecommerce.model.dto.OrderItemUpdateRequestDTO;
import com.example.ecommerce.ecommerce.model.entity.OrderItem;
import com.example.ecommerce.ecommerce.model.entity.Product;
import com.example.ecommerce.ecommerce.model.vto.OrderItemsVTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {
    private final OrderItemRepository orderItemRepository;
    private final ProductRepository productRepository;
    private final GeneralMapper mapper;

    @Override
    public OrderItemsVTO getOrderItemsByOrderId(Long id) {
        return null;
    }

    @Override
    public void addOrderItem(OrderItemDTO orderItemDTO) {
        Product product=productRepository.findByProductId(orderItemDTO.getProduct_id()).orElseThrow();
        OrderItem orderItem=OrderItem.builder().product(product).quantity(orderItemDTO.getQuantity()).priceAtPurchase(orderItemDTO.getPriceAtPurchase()).build();
        orderItemRepository.addOrderItem(orderItem);
    }

    @Override
    public void updateOrderItem(OrderItemUpdateRequestDTO orderItemDTO) {
        orderItemRepository.findOrderItemById(orderItemDTO.getId()).orElseThrow();
        OrderItem orderItem = mapper.toOrderItem(orderItemDTO);
        orderItemRepository.addOrderItem(orderItem);
    }
}
