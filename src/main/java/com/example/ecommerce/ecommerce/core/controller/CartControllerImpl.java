package com.example.ecommerce.ecommerce.core.controller;

import com.example.ecommerce.ecommerce.api.controller.CartController;
import com.example.ecommerce.ecommerce.model.dto.CartItemRequestDTO;
import com.example.ecommerce.ecommerce.model.dto.CartItemUpdateRequestDTO;
import com.example.ecommerce.ecommerce.model.vto.CartVTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
@AllArgsConstructor
public class CartControllerImpl implements CartController {
    @Override
    public ResponseEntity<CartVTO> getCart() {
        return null;
    }

    @Override
    public ResponseEntity<Void> clearCart() {
        return null;
    }

    @Override
    public ResponseEntity<CartVTO> addItemToCart(CartItemRequestDTO cartItemRequestDTO) {
        return null;
    }

    @Override
    public ResponseEntity<CartVTO> updateItemQuantity(CartItemUpdateRequestDTO cartItemUpdateRequestDTO) {
        return null;
    }
}
