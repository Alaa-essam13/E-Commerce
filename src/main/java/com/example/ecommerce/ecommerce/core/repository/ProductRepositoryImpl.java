package com.example.ecommerce.ecommerce.core.repository;

import com.example.ecommerce.ecommerce.api.repository.ProductRepository;
import com.example.ecommerce.ecommerce.core.repository.jpa.ProductJPARepository;
import com.example.ecommerce.ecommerce.model.entity.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {

    private final ProductJPARepository productJPARepository;

    @Override
    public List<Product> findAllProducts() {
        return List.of();
    }

    @Override
    public void addProduct(Product product) {
        productJPARepository.save(product);
    }

    @Override
    public Optional<Product> findByProductId(Long productId) {
        return productJPARepository.findById(productId);
    }

    @Override
    public void updateProduct(Product product) {
        productJPARepository.save(product);
    }

    @Override
    public void deleteProduct(Long productId) {
        productJPARepository.deleteById(productId);
    }
}
