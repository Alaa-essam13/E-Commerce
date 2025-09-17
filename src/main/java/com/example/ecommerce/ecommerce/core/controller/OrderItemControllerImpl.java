package com.example.ecommerce.ecommerce.core.controller;

import com.example.ecommerce.ecommerce.api.controller.OrderItemController;
import com.example.ecommerce.ecommerce.api.service.OrderItemService;
import com.example.ecommerce.ecommerce.model.dto.OrderItemDTO;
import com.example.ecommerce.ecommerce.model.dto.OrderItemUpdateRequestDTO;
import com.example.ecommerce.ecommerce.model.vto.OrderItemsVTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/orders/items")
@AllArgsConstructor
public class OrderItemControllerImpl implements OrderItemController {
    private final OrderItemService orderItemService;
    @Override
    public ResponseEntity<OrderItemsVTO> getOrderItemsByOrderId(Long id) {
        return ResponseEntity.ok(orderItemService.getOrderItemsByOrderId(id));
    }

    @Override
    public ResponseEntity<Void> addOrderItem(OrderItemDTO orderItemDTO) {
        orderItemService.addOrderItem(orderItemDTO);
        return ResponseEntity.status(CREATED).build();
    }

    @Override
    public ResponseEntity<Void> updateOrderItem(OrderItemUpdateRequestDTO orderItemDTO) {
        orderItemService.updateOrderItem(orderItemDTO);
        return ResponseEntity.status(ACCEPTED).build();
    }
}
