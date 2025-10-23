package com.example.ecommerce.ecommerce.core.controller;

import com.example.ecommerce.ecommerce.api.controller.CartController;
import com.example.ecommerce.ecommerce.api.service.CartService;
import com.example.ecommerce.ecommerce.model.vto.CartVTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.ACCEPTED;

@RestController
@RequestMapping("/cart")
@AllArgsConstructor
public class CartControllerImpl implements CartController {
    private final CartService cartService;
    @Override
    public ResponseEntity<CartVTO> getCart(Long id) {
        return ResponseEntity.ok(cartService.getCart(id));
    }

    @Override
    public ResponseEntity<Void> clearCart(Long id) {
        cartService.clearCart(id);
        return ResponseEntity.status(ACCEPTED).build();
    }


}
