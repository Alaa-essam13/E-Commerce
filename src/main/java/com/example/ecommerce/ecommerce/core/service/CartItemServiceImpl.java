package com.example.ecommerce.ecommerce.core.service;

import com.example.ecommerce.ecommerce.api.repository.CartItemRepository;
import com.example.ecommerce.ecommerce.api.repository.CartRepoitory;
import com.example.ecommerce.ecommerce.api.repository.ProductRepository;
import com.example.ecommerce.ecommerce.api.service.CartItemService;
import com.example.ecommerce.ecommerce.lib.error.AppException;
import com.example.ecommerce.ecommerce.model.dto.CartItemRequestDTO;
import com.example.ecommerce.ecommerce.model.dto.CartItemUpdateRequestDTO;
import com.example.ecommerce.ecommerce.model.entity.Cart;
import com.example.ecommerce.ecommerce.model.entity.CartItem;
import com.example.ecommerce.ecommerce.model.entity.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.ecommerce.ecommerce.lib.error.Error.CART_ITEM_NOT_FOUND;
import static com.example.ecommerce.ecommerce.lib.error.Error.PRODUCT_NOT_FOUND;

@Service
@AllArgsConstructor
public class CartItemServiceImpl implements CartItemService {
    private final CartItemRepository cartItemRepository;
    private final CartRepoitory cartRepoitory;
    private final ProductRepository productRepository;
    @Override
    public void addItemToCart(CartItemRequestDTO cartItemRequestDTO) {
        Cart cart= cartRepoitory.findCart(cartItemRequestDTO.getCartId()).orElseThrow(()-> new AppException(CART_ITEM_NOT_FOUND));
        Product product= productRepository.findByProductId(cartItemRequestDTO.getProductId()).orElseThrow(()-> new AppException(PRODUCT_NOT_FOUND));
        cartItemRepository.addCartItem(CartItem.builder().cart(cart).product(product).quantity(cartItemRequestDTO.getQuantity()).build());
    }

    @Override
    public void updateItemQuantity(CartItemUpdateRequestDTO cartItemUpdateRequestDTO) {
        CartItem cartItem=cartItemRepository.getById(cartItemUpdateRequestDTO.getCartItemId()).orElseThrow(()-> new AppException(CART_ITEM_NOT_FOUND));
        if(cartItemUpdateRequestDTO.getQuantity()<=0){
            cartItemRepository.removeCartItems(cartItem.getId());
        }else{
            cartItem.setQuantity(cartItemUpdateRequestDTO.getQuantity());
            cartItemRepository.updateCartItem(cartItem);
        }

    }

    @Override
    public void deleteCartItem(Long id) {
    cartItemRepository.getById(id).orElseThrow(()-> new AppException(CART_ITEM_NOT_FOUND));
    cartItemRepository.removeCartItems(id);
    }
}
