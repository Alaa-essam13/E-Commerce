package com.example.ecommerce.ecommerce.core.controller;

import com.example.ecommerce.ecommerce.api.controller.CartItemController;
import com.example.ecommerce.ecommerce.api.service.CartItemService;
import com.example.ecommerce.ecommerce.model.dto.CartItemRequestDTO;
import com.example.ecommerce.ecommerce.model.dto.CartItemUpdateRequestDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.ACCEPTED;

@RestController
@RequestMapping("/cartItem")
@AllArgsConstructor
public class CartItemControllerImpl implements CartItemController {
    private final CartItemService cartItemService;

    @Override
    public ResponseEntity<Void> addItemToCart(@Valid @RequestBody CartItemRequestDTO cartItemRequestDTO) {
        cartItemService.addItemToCart(cartItemRequestDTO);
        return ResponseEntity.status(ACCEPTED).build();
    }

    @Override
    public ResponseEntity<Void> updateItemQuantity(@Valid @RequestBody CartItemUpdateRequestDTO cartItemUpdateRequestDTO) {
        cartItemService.updateItemQuantity(cartItemUpdateRequestDTO);
        return ResponseEntity.status(ACCEPTED).build();
    }

    @Override
    public ResponseEntity<Void> deleteCartItem(Long id) {
        cartItemService.deleteCartItem(id);
        return ResponseEntity.status(ACCEPTED).build();
    }
}
