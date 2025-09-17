package com.example.ecommerce.ecommerce.api.controller;


import com.example.ecommerce.ecommerce.model.dto.OrderItemDTO;
import com.example.ecommerce.ecommerce.model.dto.OrderItemUpdateRequestDTO;
import com.example.ecommerce.ecommerce.model.vto.OrderItemVTO;
import com.example.ecommerce.ecommerce.model.vto.OrderItemsVTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@Validated
public interface OrderItemController {
    @GetMapping(path = "/{id}",produces = {"application/json"})
    ResponseEntity<OrderItemsVTO> getOrderItemsByOrderId(@PathVariable Long id);

    @PostMapping(produces = {"application/json"})
    ResponseEntity<Void> addOrderItem(@Valid @RequestBody OrderItemDTO orderItemDTO);

    @PutMapping(produces = {"application/json"})
    ResponseEntity<Void> updateOrderItem(@Valid @RequestBody OrderItemUpdateRequestDTO orderItemDTO);
}
