package com.example.ecommerce.ecommerce.core.service;

import com.example.ecommerce.ecommerce.api.service.CartService;
import com.example.ecommerce.ecommerce.model.dto.CartItemRequestDTO;
import com.example.ecommerce.ecommerce.model.dto.CartItemUpdateRequestDTO;
import com.example.ecommerce.ecommerce.model.vto.CartVTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService {

    @Override
    public CartVTO getCart() {
        return null;
    }

    @Override
    public void clearCart() {

    }

    @Override
    public CartVTO addItemToCart(CartItemRequestDTO cartItemRequestDTO) {
        return null;
    }

    @Override
    public CartVTO updateItemQuantity(CartItemUpdateRequestDTO cartItemUpdateRequestDTO) {
        return null;
    }
}
