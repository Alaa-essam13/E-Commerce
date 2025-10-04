package com.example.ecommerce.ecommerce.core.repository;

import com.example.ecommerce.ecommerce.api.repository.CartRepoitory;
import com.example.ecommerce.ecommerce.core.repository.jpa.CartJPARepoitory;
import com.example.ecommerce.ecommerce.model.entity.Cart;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class CartRepositoryImpl implements CartRepoitory {

    private final CartJPARepoitory cartJPARepoitory;


    @Override
    public Optional<Cart> findCart(Long id) {
        return cartJPARepoitory.findById(id);
    }


    @Override
    public void addCart(Cart cart) {
        cartJPARepoitory.save(cart);
    }
}
