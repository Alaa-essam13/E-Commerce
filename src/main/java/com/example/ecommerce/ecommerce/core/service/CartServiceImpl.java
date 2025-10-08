package com.example.ecommerce.ecommerce.core.service;

import com.example.ecommerce.ecommerce.api.repository.CartItemRepository;
import com.example.ecommerce.ecommerce.api.repository.CartRepoitory;
import com.example.ecommerce.ecommerce.api.repository.ProductRepository;
import com.example.ecommerce.ecommerce.api.service.CartService;
import com.example.ecommerce.ecommerce.lib.error.AppException;
import com.example.ecommerce.ecommerce.mapper.GeneralMapper;
import com.example.ecommerce.ecommerce.model.entity.Cart;
import com.example.ecommerce.ecommerce.model.entity.CartItem;
import com.example.ecommerce.ecommerce.model.vto.CartVTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.ecommerce.ecommerce.lib.error.Error.CART_NOT_FOUND;

@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartRepoitory cartRepoitory;
    private final CartItemRepository cartItemRepository;
    private final ProductRepository productRepository;
    private final GeneralMapper mapper;
    @Override
    public CartVTO getCart(Long id) {
        Cart cart = cartRepoitory.findCart(id).orElseThrow(()->new AppException(CART_NOT_FOUND));
        List<CartItem> cartItems = cartItemRepository.getCartItemsByCartId(cart.getId());
        double subtotal = cartItems.stream()
                .mapToDouble(itm -> itm.getProduct().getPrice() * itm.getQuantity())
                .sum();

        return CartVTO.builder().items(mapper.toCartItemsVTO(cartItems)).totalItems(cartItems.size()).subtotal(subtotal).build();
    }

    @Override
    public void clearCart(Long id) {
        cartRepoitory.findCart(id).orElseThrow(()->new AppException(CART_NOT_FOUND));
        cartItemRepository.removeCartItems(id);
    }


}
