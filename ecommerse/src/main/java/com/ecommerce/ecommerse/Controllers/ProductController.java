package com.ecommerce.ecommerse.Controllers;

import com.ecommerce.ecommerse.Models.Product;
import com.ecommerce.ecommerse.Models.Request;
import com.ecommerce.ecommerse.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/Admin/AddProduct")
    public ResponseEntity<?> AddProduct(@RequestBody Product product) {
        productService.AddProduct(product);
        return ResponseEntity.ok(true);
    }

    @PutMapping("/Admin/UpdateProduct")
    public ResponseEntity<?> UpdateProduct(@RequestBody Product product) {
        productService.updateProduct(product);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/GetAllProduct")
    public ResponseEntity<?> GetAllProduct() {
        return ResponseEntity.ok().body(productService.getAllProducts());
    }
    @GetMapping("/GetAllProductPaginated")
    public ResponseEntity<?> getAllProductsPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){
                Page<Product> products = productService.getAllProductsPaginated(page, size);
                return ResponseEntity.ok(products);
        }

    @GetMapping("/GetProductById/{id}")
    public ResponseEntity<?> GetProductById(@PathVariable int id) {
        return ResponseEntity.ok().body(productService.getProductById(id));
    }

    @GetMapping("/Admin/GetDeletedProducts")
    public ResponseEntity<?> GetDeletedProducts() {
        return ResponseEntity.ok().body(productService.getDeletedProducts());
    }

    @GetMapping("/GetProductsByCategoryName")
    public ResponseEntity<List<Product>> getProductsByCategoryName(@RequestBody Request request) {
        List<Product> products = productService.GetProductByCategoryName(request.getCategoryName());
        if (products.isEmpty()) {
            return ResponseEntity.status(404).body(null); // Category or products not found
        }
        return ResponseEntity.ok(products);
    }

    @DeleteMapping("/Admin/DeleteProduct/{id}")
    public ResponseEntity<?> DeleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/SearchProduct")
    public ResponseEntity<?> SearchProduct(@RequestBody Request request) {
        return ResponseEntity.ok().body(productService.FindByName(request.getProductName()));
    }






}
