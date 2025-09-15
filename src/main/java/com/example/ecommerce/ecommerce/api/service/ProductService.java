package com.example.ecommerce.ecommerce.api.service;

import com.example.ecommerce.ecommerce.model.dto.ProductCreateRequestDTO;
import com.example.ecommerce.ecommerce.model.dto.ProductUpdateRequestDTO;
import com.example.ecommerce.ecommerce.model.vto.PagedProductResponseVTO;
import com.example.ecommerce.ecommerce.model.vto.ProductVTO;

public interface ProductService {

    PagedProductResponseVTO getProducts();

    void createProduct(ProductCreateRequestDTO productCreateRequestDTO);

    ProductVTO getProductById(Long id);

    void updateProduct(ProductUpdateRequestDTO productUpdateRequestDTO);

    void deleteProduct( Long id);
}
