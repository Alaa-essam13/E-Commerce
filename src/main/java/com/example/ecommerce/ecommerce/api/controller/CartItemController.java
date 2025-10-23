package com.example.ecommerce.ecommerce.api.controller;

import com.example.ecommerce.ecommerce.model.dto.CartItemRequestDTO;
import com.example.ecommerce.ecommerce.model.dto.CartItemUpdateRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@Validated
public interface CartItemController {

    @PostMapping(produces = {"application/json"})
    ResponseEntity<Void> addItemToCart(@RequestBody CartItemRequestDTO cartItemRequestDTO);

    @PatchMapping(produces = {"application/json"})
    ResponseEntity<Void> updateItemQuantity(@RequestBody CartItemUpdateRequestDTO cartItemUpdateRequestDTO);

    @DeleteMapping(path = "/{id}",produces = {"application/json"})
    ResponseEntity<Void> deleteCartItem(@PathVariable("id") Long id);

}
