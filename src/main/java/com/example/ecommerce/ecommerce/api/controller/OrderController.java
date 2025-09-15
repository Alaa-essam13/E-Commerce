package com.example.ecommerce.ecommerce.api.controller;

import com.example.ecommerce.ecommerce.model.vto.OrderVTO;
import com.example.ecommerce.ecommerce.model.vto.PagedOrderResponseVTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@Validated
public interface OrderController {

    @GetMapping(produces = {"application/json"})
    ResponseEntity<PagedOrderResponseVTO> getAllOrders();

    @GetMapping(path = "/{id}",produces = {"application/json"})
    ResponseEntity<OrderVTO> getOrderById(@PathVariable Long id);
}
