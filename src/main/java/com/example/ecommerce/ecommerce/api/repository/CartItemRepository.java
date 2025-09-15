package com.example.ecommerce.ecommerce.api.repository;

import com.example.ecommerce.ecommerce.model.entity.CartItem;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository {

    void addCartItem(CartItem cartItem);

    void removeCartItem(CartItem cartItem);

    void updateCartItem(CartItem cartItem);
}
