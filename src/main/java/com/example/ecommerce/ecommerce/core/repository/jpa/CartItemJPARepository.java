package com.example.ecommerce.ecommerce.core.repository.jpa;

import com.example.ecommerce.ecommerce.model.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartItemJPARepository extends JpaRepository<CartItem, Long> {
   @Query(value = "SELECT ci FROM CartItem ci WHERE ci.cart.id = :id")
    List<CartItem> findAllByCartId(@Param("id") Long id);

   @Modifying
   @Query("DELETE FROM CartItem ci WHERE ci.cart.id= :id")
    void deleteByCartId(@Param("id") Long id);
}
