package com.example.ecommerce.ecommerce.core.controller;

import com.example.ecommerce.ecommerce.api.controller.OrderController;
import com.example.ecommerce.ecommerce.model.vto.OrderVTO;
import com.example.ecommerce.ecommerce.model.vto.PagedOrderResponseVTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@AllArgsConstructor
public class OrderControllerImpl implements OrderController {
    @Override
    public ResponseEntity<PagedOrderResponseVTO> getAllOrders() {
        return null;
    }

    @Override
    public ResponseEntity<OrderVTO> getOrderById(Long id) {
        return null;
    }
}
