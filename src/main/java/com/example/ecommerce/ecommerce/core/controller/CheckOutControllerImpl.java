package com.example.ecommerce.ecommerce.core.controller;

import com.example.ecommerce.ecommerce.api.controller.CheckOutController;
import com.example.ecommerce.ecommerce.model.dto.CheckoutRequestDTO;
import com.example.ecommerce.ecommerce.model.vto.OrderVTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/checkout")
@AllArgsConstructor
public class CheckOutControllerImpl implements CheckOutController {
    @Override
    public ResponseEntity<OrderVTO> checkOut(CheckoutRequestDTO value) {
        return null;
    }
}
