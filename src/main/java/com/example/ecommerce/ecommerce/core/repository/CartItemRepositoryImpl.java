package com.example.ecommerce.ecommerce.core.repository;

import com.example.ecommerce.ecommerce.api.repository.CartItemRepository;
import com.example.ecommerce.ecommerce.core.repository.jpa.CartItemJPARepository;
import com.example.ecommerce.ecommerce.model.entity.CartItem;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class CartItemRepositoryImpl implements CartItemRepository {

    private final CartItemJPARepository cartItemJPARepository;

    @Override
    public void addCartItem(CartItem cartItem) {
        cartItemJPARepository.save(cartItem);
    }

    @Override
    public Optional<CartItem> getById(Long cartItemId) {
        return cartItemJPARepository.findById(cartItemId);
    }

    @Override
    public void removeCartItem(CartItem cartItem) {
        cartItemJPARepository.delete(cartItem);
    }

    @Override
    public void updateCartItem(CartItem cartItem) {
        cartItemJPARepository.save(cartItem);
    }

    @Override
    public List<CartItem> getCartItemsByCartId(Long id) {
        return cartItemJPARepository.findAllByCartId(id);
    }

    @Override
    public void removeCartItems(Long id) {
        cartItemJPARepository.deleteByCartId(id);
    }
}
