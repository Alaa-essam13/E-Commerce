package com.example.ecommerce.ecommerce.core.controller;

import com.example.ecommerce.ecommerce.api.controller.OrderController;
import com.example.ecommerce.ecommerce.api.service.OrderService;
import com.example.ecommerce.ecommerce.model.dto.OrderDTO;
import com.example.ecommerce.ecommerce.model.vto.OrderVTO;
import com.example.ecommerce.ecommerce.model.vto.PagedOrderResponseVTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/orders")
@AllArgsConstructor
public class OrderControllerImpl implements OrderController {
    private final OrderService orderService;
    @Override
    public ResponseEntity<PagedOrderResponseVTO> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @Override
    public ResponseEntity<OrderVTO> getOrderById(Long id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }

    @Override
    public ResponseEntity<Void> addOrder(OrderDTO orderDTO) {
        orderService.addOrder(orderDTO);
        return ResponseEntity.status(CREATED).build();
    }
}
