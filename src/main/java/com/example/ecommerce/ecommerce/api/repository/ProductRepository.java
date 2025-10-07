package com.example.ecommerce.ecommerce.api.repository;

import com.example.ecommerce.ecommerce.model.dto.ProductFilterDTO;
import com.example.ecommerce.ecommerce.model.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository{
    List<Product> findAllProducts(ProductFilterDTO productFilterDTO, Integer offset, Integer limit);
    void addProduct(Product product);
    Optional<Product> findByProductId(Long productId);
    void updateProduct(Product product);
    void deleteProduct(Long productId);

    Long getCount(ProductFilterDTO productFilterDTO);
}
