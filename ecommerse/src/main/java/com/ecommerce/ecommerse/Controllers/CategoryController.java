package com.ecommerce.ecommerse.Controllers;

import com.ecommerce.ecommerse.Models.Category;
import com.ecommerce.ecommerse.Models.Product;
import com.ecommerce.ecommerse.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/Admin/CreateCategory")
    public ResponseEntity<?> CreateCategory(@RequestBody Category category) {
        categoryService.saveCategory(category);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/Admin/UpdateCategory")
    public ResponseEntity<?> UpdateCategory(@RequestBody Category category) {
        categoryService.updateCategory(category);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/GetAllCategories")
    public ResponseEntity<?> GetAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @GetMapping("/GetCategoryById/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable int id) {
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }

    @DeleteMapping("/Admin/DeleteCategory/{id}")
    public ResponseEntity<?> DeleteCategory(@PathVariable int id) {
        categoryService.deleteCategoryById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/GetAllCategoriesPaginated")
    public ResponseEntity<?> getAllCategoriesPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){
        Page<Category> categories = categoryService.getAllCategoriesPaginated(page, size);
        return ResponseEntity.ok(categories);
    }



}
