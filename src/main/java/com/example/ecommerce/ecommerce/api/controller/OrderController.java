package com.example.ecommerce.ecommerce.api.controller;

import com.example.ecommerce.ecommerce.model.dto.OrderDTO;
import com.example.ecommerce.ecommerce.model.vto.OrderVTO;
import com.example.ecommerce.ecommerce.model.vto.PagedOrderResponseVTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@Validated
public interface OrderController {

    @GetMapping(produces = {"application/json"})
    ResponseEntity<PagedOrderResponseVTO> getAllOrders();

    @GetMapping(path = "/{id}",produces = {"application/json"})
    ResponseEntity<OrderVTO> getOrderById(@PathVariable Long id);

    @PostMapping(produces = {"application/json"})
    ResponseEntity<Void> addOrder(@RequestBody OrderDTO orderDTO);
}
