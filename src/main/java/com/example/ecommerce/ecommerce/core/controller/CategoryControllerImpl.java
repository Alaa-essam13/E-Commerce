package com.example.ecommerce.ecommerce.core.controller;

import com.example.ecommerce.ecommerce.api.controller.CategoryController;
import com.example.ecommerce.ecommerce.api.service.CategoryService;
import com.example.ecommerce.ecommerce.model.dto.CategoryDTO;
import com.example.ecommerce.ecommerce.model.entity.Category;
import com.example.ecommerce.ecommerce.model.vto.CategoriesVTO;
import com.example.ecommerce.ecommerce.model.vto.CategoryVTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.ACCEPTED;

@RestController
@RequestMapping("/category")
@AllArgsConstructor
public class CategoryControllerImpl implements CategoryController {
    private final CategoryService categoryService;
    @Override
    public ResponseEntity<Void> addCategory(@Valid @RequestBody CategoryDTO category) {
         categoryService.addCategory(category);
         return ResponseEntity.status(ACCEPTED).build();
    }

    @Override
    public ResponseEntity<CategoriesVTO> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @Override
    public ResponseEntity<CategoryVTO> getCategoryById(Integer id) {
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }

}
