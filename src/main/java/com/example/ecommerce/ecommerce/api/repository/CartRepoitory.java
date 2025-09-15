package com.example.ecommerce.ecommerce.api.repository;

import com.example.ecommerce.ecommerce.model.entity.Cart;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepoitory {

    Cart findCart();

    void clearCart();

}
