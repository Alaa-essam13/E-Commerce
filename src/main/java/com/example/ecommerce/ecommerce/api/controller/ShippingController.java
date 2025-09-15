package com.example.ecommerce.ecommerce.api.controller;

import com.example.ecommerce.ecommerce.model.dto.ShippingCostRequestDTO;
import com.example.ecommerce.ecommerce.model.vto.ShippingCostResponseVTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@Validated
public interface ShippingController {

    @PostMapping(produces = {"application/json"})
    ResponseEntity<ShippingCostResponseVTO> createShipping(@RequestBody ShippingCostRequestDTO shippingCostRequestDTO);
}