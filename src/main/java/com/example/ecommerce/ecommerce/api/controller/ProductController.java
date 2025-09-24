package com.example.ecommerce.ecommerce.api.controller;

import com.example.ecommerce.ecommerce.model.dto.ProductCreateRequestDTO;
import com.example.ecommerce.ecommerce.model.dto.ProductUpdateRequestDTO;
import com.example.ecommerce.ecommerce.model.vto.PagedProductResponseVTO;
import com.example.ecommerce.ecommerce.model.vto.ProductVTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@Validated
public interface ProductController {
    @GetMapping
    ResponseEntity<PagedProductResponseVTO> getProducts();

    @PostMapping(produces = {"application/json"})
    ResponseEntity<Void> createProduct(@Valid @RequestBody ProductCreateRequestDTO productCreateRequestDTO);

    @GetMapping(path = "/{id}",produces = {"application/json"})
    ResponseEntity<ProductVTO> getProductById(@PathVariable("id") Long id);

    @PutMapping(path = "/{id}",produces = {"application/json"})
    ResponseEntity<Void> updateProduct(@PathVariable("id") Long id,@Valid @RequestBody ProductUpdateRequestDTO productUpdateRequestDTO);

    @DeleteMapping(path = "/{id}",produces = {"application/json"})
    ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id);
}
