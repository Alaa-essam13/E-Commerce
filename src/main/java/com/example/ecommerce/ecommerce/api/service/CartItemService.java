package com.example.ecommerce.ecommerce.api.service;

import com.example.ecommerce.ecommerce.model.dto.CartItemRequestDTO;
import com.example.ecommerce.ecommerce.model.dto.CartItemUpdateRequestDTO;

public interface CartItemService {

    void addItemToCart(CartItemRequestDTO cartItemRequestDTO);

    void updateItemQuantity(CartItemUpdateRequestDTO cartItemUpdateRequestDTO);

    void deleteCartItem(Long id);

}
