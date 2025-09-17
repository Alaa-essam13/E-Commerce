package com.example.ecommerce.ecommerce.core.service;

import com.example.ecommerce.ecommerce.api.repository.CategoryRepository;
import com.example.ecommerce.ecommerce.api.repository.ProductRepository;
import com.example.ecommerce.ecommerce.api.service.ProductService;
import com.example.ecommerce.ecommerce.mapper.GeneralMapper;
import com.example.ecommerce.ecommerce.model.dto.ProductCreateRequestDTO;
import com.example.ecommerce.ecommerce.model.dto.ProductUpdateRequestDTO;
import com.example.ecommerce.ecommerce.model.entity.Category;
import com.example.ecommerce.ecommerce.model.entity.Product;
import com.example.ecommerce.ecommerce.model.vto.PagedProductResponseVTO;
import com.example.ecommerce.ecommerce.model.vto.ProductVTO;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final GeneralMapper mapper;
    private final CategoryRepository categoryRepository;

    @Override
    public PagedProductResponseVTO getProducts() {
        return null;
    }

    @Override
    @Transactional
    public void createProduct(ProductCreateRequestDTO productCreateRequestDTO) {
        Product product = mapper.toProduct(productCreateRequestDTO);
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());
        Category c=categoryRepository.getCategoryById(productCreateRequestDTO.getCategory()).orElseThrow();
        product.setCategory(c);
        System.out.println(product.getCategory().getName());
        productRepository.addProduct(product);
    }

    @Override
    public ProductVTO getProductById(Long id) {
        Product p = productRepository.findByProductId(id).orElseThrow();
        return mapper.toProductVTO(p);
    }

    @Override
    public void updateProduct(ProductUpdateRequestDTO productUpdateRequestDTO) {
        productRepository.findByProductId(productUpdateRequestDTO.getId()).orElseThrow();
        productRepository.updateProduct(mapper.toProduct(productUpdateRequestDTO));
    }

    @Override
    public void deleteProduct(Long id) {
        Product p =productRepository.findByProductId(id).orElseThrow();
        productRepository.deleteProduct(p.getId());
    }
}
