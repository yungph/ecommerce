package com.ecommerce.ecommerse.Controllers;

import com.ecommerce.ecommerse.Models.Cart;
import com.ecommerce.ecommerse.Models.Request;
import com.ecommerce.ecommerse.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    // Add product to cart
//    @PostMapping("/addProduct")
//    public ResponseEntity<?> addProductToCart(@RequestBody Request request) {
//        // Check if cartId is null
//        if (request.getCartId() == null) {
//            // Create a new cart and get its ID
//            Cart newCart = cartService.createCart(); // Create this method in your CartService
//            cartService.addProductToCart(newCart.getId(), request.getProductId(), request.getQuantity());
//            return ResponseEntity.ok().build();
//        }
//        cartService.addProductToCart(request.getCartId(), request.getProductId(), request.getQuantity());
//        return ResponseEntity.ok().build();
//    }

    // Remove product from cart
    @DeleteMapping("/removeProduct")
    public Cart removeProductFromCart( @RequestBody Request request) {
        return cartService.removeProductFromCart(request.getCartId(), request.getProductId());
    }
}
