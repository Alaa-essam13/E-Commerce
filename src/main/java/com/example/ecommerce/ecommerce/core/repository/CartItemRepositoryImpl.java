package com.example.ecommerce.ecommerce.core.repository;

import com.example.ecommerce.ecommerce.api.repository.CartItemRepository;
import com.example.ecommerce.ecommerce.core.repository.jpa.CartItemJPARepository;
import com.example.ecommerce.ecommerce.model.entity.CartItem;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class CartItemRepositoryImpl implements CartItemRepository {

    private final CartItemJPARepository cartItemJPARepository;

    @Override
    public void addCartItem(CartItem cartItem) {

    }

    @Override
    public void removeCartItem(CartItem cartItem) {

    }

    @Override
    public void updateCartItem(CartItem cartItem) {

    }
}
