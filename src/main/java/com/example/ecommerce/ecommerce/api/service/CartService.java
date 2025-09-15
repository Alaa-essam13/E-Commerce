package com.example.ecommerce.ecommerce.api.service;

import com.example.ecommerce.ecommerce.model.dto.CartItemRequestDTO;
import com.example.ecommerce.ecommerce.model.dto.CartItemUpdateRequestDTO;
import com.example.ecommerce.ecommerce.model.vto.CartVTO;

public interface CartService {

    CartVTO getCart();

    void clearCart();

    CartVTO addItemToCart(CartItemRequestDTO cartItemRequestDTO);

    CartVTO updateItemQuantity(CartItemUpdateRequestDTO cartItemUpdateRequestDTO);


}
