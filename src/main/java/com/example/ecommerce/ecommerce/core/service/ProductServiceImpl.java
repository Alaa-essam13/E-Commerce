package com.example.ecommerce.ecommerce.core.service;

import com.example.ecommerce.ecommerce.api.repository.CategoryRepository;
import com.example.ecommerce.ecommerce.api.repository.ProductRepository;
import com.example.ecommerce.ecommerce.api.service.ProductService;
import com.example.ecommerce.ecommerce.lib.error.AppException;
import com.example.ecommerce.ecommerce.mapper.GeneralMapper;
import com.example.ecommerce.ecommerce.model.dto.ProductCreateRequestDTO;
import com.example.ecommerce.ecommerce.model.dto.ProductFilterDTO;
import com.example.ecommerce.ecommerce.model.dto.ProductUpdateRequestDTO;
import com.example.ecommerce.ecommerce.model.entity.Category;
import com.example.ecommerce.ecommerce.model.entity.Product;
import com.example.ecommerce.ecommerce.model.enums.ProductSortBy;
import com.example.ecommerce.ecommerce.model.enums.SortDirection;
import com.example.ecommerce.ecommerce.model.vto.PagedProductResponseVTO;
import com.example.ecommerce.ecommerce.model.vto.ProductVTO;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static com.example.ecommerce.ecommerce.lib.error.Error.PRODUCT_NOT_FOUND;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final GeneralMapper mapper;
    private final CategoryRepository categoryRepository;


    @Override
    public PagedProductResponseVTO getProducts(Integer offset,Integer limit,String searchTxt, SortDirection direction, ProductSortBy sortedBy, Double minPrice, Double maxPrice, Integer categoryId) {
        ProductFilterDTO productFilterDTO = ProductFilterDTO.builder()
                .sortType(sortedBy)
                .sortDirection(direction)
                .minPrice(minPrice)
                .maxPrice(maxPrice)
                .searchTxt(searchTxt)
                .category(categoryId)
                .build();
         List<Product> productList=productRepository.findAllProducts(productFilterDTO,offset,limit);
         return mapper.toPagedProductResponseVTO(productList,productRepository.getCount(productFilterDTO));
    }

    @Override
    @Transactional
    public void createProduct(ProductCreateRequestDTO productCreateRequestDTO) {
        Category c=categoryRepository.getCategoryById(productCreateRequestDTO.getCategoryId()).orElseThrow();
        Product product = mapper.toProduct(productCreateRequestDTO,c);
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());
        product.setCategory(c);
        productRepository.addProduct(product);
    }

    @Override
    public ProductVTO getProductById(Long id) {
        Product p = productRepository.findByProductId(id).orElseThrow(()->new AppException(PRODUCT_NOT_FOUND));
        return mapper.toProductVTO(p);
    }

    @Override
    public void updateProduct(Long id,ProductUpdateRequestDTO productUpdateRequestDTO) {
        productRepository.findByProductId(productUpdateRequestDTO.getId()).orElseThrow(()->new AppException(PRODUCT_NOT_FOUND));
        productRepository.updateProduct(mapper.toProduct(productUpdateRequestDTO));
    }

    @Override
    public void deleteProduct(Long id) {
        Product p =productRepository.findByProductId(id).orElseThrow(()->new AppException(PRODUCT_NOT_FOUND));
        productRepository.deleteProduct(p.getId());
    }
}
