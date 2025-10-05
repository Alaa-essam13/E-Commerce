package com.example.ecommerce.ecommerce.api.controller;

import com.example.ecommerce.ecommerce.model.dto.CartItemRequestDTO;
import com.example.ecommerce.ecommerce.model.dto.CartItemUpdateRequestDTO;
import com.example.ecommerce.ecommerce.model.vto.CartVTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@Validated
public interface CartController {

    @GetMapping(path = "/{id}",produces = {"application/json"})
    ResponseEntity<CartVTO> getCart(@PathVariable("id") Long id);

    @DeleteMapping(path = "/{id}",produces = {"application/json"})
    ResponseEntity<Void> clearCart(@PathVariable("id") Long id);


}
