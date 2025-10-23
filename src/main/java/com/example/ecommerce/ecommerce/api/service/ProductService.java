package com.example.ecommerce.ecommerce.api.service;

import com.example.ecommerce.ecommerce.model.dto.ProductCreateRequestDTO;
import com.example.ecommerce.ecommerce.model.dto.ProductUpdateRequestDTO;
import com.example.ecommerce.ecommerce.model.enums.ProductSortBy;
import com.example.ecommerce.ecommerce.model.enums.SortDirection;
import com.example.ecommerce.ecommerce.model.vto.PagedProductResponseVTO;
import com.example.ecommerce.ecommerce.model.vto.ProductVTO;

public interface ProductService {

    PagedProductResponseVTO getProducts(Integer offset,Integer limit,String searchTxt, SortDirection direction, ProductSortBy sortedBy,Double minPrice, Double maxPrice,Integer categoryId);

    void createProduct(ProductCreateRequestDTO productCreateRequestDTO);

    ProductVTO getProductById(Long id);

    void updateProduct(Long id,ProductUpdateRequestDTO productUpdateRequestDTO);

    void deleteProduct( Long id);
}
