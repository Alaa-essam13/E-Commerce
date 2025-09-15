package com.example.ecommerce.ecommerce.core.controller;

import com.example.ecommerce.ecommerce.api.controller.ShippingController;
import com.example.ecommerce.ecommerce.model.dto.ShippingCostRequestDTO;
import com.example.ecommerce.ecommerce.model.vto.ShippingCostResponseVTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shipping")
@AllArgsConstructor
public class ShippingControllerImpl implements ShippingController {
    @Override
    public ResponseEntity<ShippingCostResponseVTO> createShipping(ShippingCostRequestDTO shippingCostRequestDTO) {
        return null;
    }
}
