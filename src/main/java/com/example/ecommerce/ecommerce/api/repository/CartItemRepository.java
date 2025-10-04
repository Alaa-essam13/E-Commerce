package com.example.ecommerce.ecommerce.api.repository;

import com.example.ecommerce.ecommerce.model.entity.CartItem;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartItemRepository {

    void addCartItem(CartItem cartItem);

    Optional<CartItem> getById(Long cartItemId);

    void removeCartItem(CartItem cartItem);

    void updateCartItem(CartItem cartItem);

    List<CartItem> getCartItemsByCartId(Long id);

    void removeCartItems(Long id);
}
