package com.example.ecommerce.ecommerce.api.controller;

import com.example.ecommerce.ecommerce.model.dto.CategoryDTO;
import com.example.ecommerce.ecommerce.model.entity.Category;
import com.example.ecommerce.ecommerce.model.enums.SortDirection;
import com.example.ecommerce.ecommerce.model.vto.CategoriesVTO;
import com.example.ecommerce.ecommerce.model.vto.CategoryVTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@Validated
public interface CategoryController {

    @PostMapping(produces = {"application/json"})
    ResponseEntity<Void> addCategory(@Valid @RequestBody CategoryDTO category);

    @GetMapping(produces = {"application/json"})
    ResponseEntity<CategoriesVTO> getAllCategories(@RequestParam("offset") Integer offset,@RequestParam("limit") Integer limit,@RequestParam("searchTxt") String searchTxt,@RequestParam("sortDirection") SortDirection sortDirection);

    @GetMapping(path = "/{id}",produces = {"application/json"})
    ResponseEntity<CategoryVTO> getCategoryById(@PathVariable Integer id);

    @DeleteMapping(path = "/{id}",produces = {"application/json"})
    ResponseEntity<Void> deleteCtegory(@PathVariable Integer id);

}
