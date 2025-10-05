package com.example.ecommerce.ecommerce.api.service;

import com.example.ecommerce.ecommerce.model.dto.CartItemRequestDTO;
import com.example.ecommerce.ecommerce.model.dto.CartItemUpdateRequestDTO;
import com.example.ecommerce.ecommerce.model.vto.CartVTO;

public interface CartService {

    CartVTO getCart(Long id);

    void clearCart(Long id);


}
