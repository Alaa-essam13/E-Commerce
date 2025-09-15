package com.example.ecommerce.ecommerce.core.controller;

import com.example.ecommerce.ecommerce.api.controller.ProductController;
import com.example.ecommerce.ecommerce.api.service.ProductService;
import com.example.ecommerce.ecommerce.model.dto.ProductCreateRequestDTO;
import com.example.ecommerce.ecommerce.model.dto.ProductUpdateRequestDTO;
import com.example.ecommerce.ecommerce.model.vto.PagedProductResponseVTO;
import com.example.ecommerce.ecommerce.model.vto.ProductVTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductControllerImpl implements ProductController {
    private final ProductService productService;
    @Override
    public ResponseEntity<PagedProductResponseVTO> getProducts() {
        return ResponseEntity.ok(productService.getProducts());
    }

    @Override
    public ResponseEntity<Void> createProduct(@Valid @RequestBody ProductCreateRequestDTO productCreateRequestDTO) {
        productService.createProduct(productCreateRequestDTO);
        return ResponseEntity.status(CREATED).build();
    }

    @Override
    public ResponseEntity<ProductVTO> getProductById(Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @Override
    public ResponseEntity<Void> updateProduct(@Valid @RequestBody ProductUpdateRequestDTO productUpdateRequestDTO) {
        productService.updateProduct(productUpdateRequestDTO);
        return ResponseEntity.status(ACCEPTED).build();
    }

    @Override
    public ResponseEntity<Void> deleteProduct(Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.status(ACCEPTED).build();
    }
}
