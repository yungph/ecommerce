package com.ecommerce.ecommerse.Service;

import com.ecommerce.ecommerse.Models.Cart;
import com.ecommerce.ecommerse.Models.CartItem;
import com.ecommerce.ecommerse.Models.Product;
import com.ecommerce.ecommerse.Repo.CartItemRepo;
import com.ecommerce.ecommerse.Repo.CartRepo;
import com.ecommerce.ecommerse.Repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {

    @Autowired
    CartItemRepo cartItemRepository;
    @Autowired
    private CartRepo cartRepository;

    @Autowired
    private ProductRepo productRepository;

    public Cart createCart() {
        Cart newCart = new Cart();
        return cartRepository.save(newCart); // Ensure you have a repository for Cart
    }


    public Cart removeProductFromCart(int cartId, int productId) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("Cart not found"));
        Optional<CartItem> cartItemOpt = cart.getItems().stream().filter(item -> item.getProduct().getId() == productId).findFirst();

        if (cartItemOpt.isPresent()) {
            cart.removeItem(cartItemOpt.get());
            return cartRepository.save(cart);
        } else {
            throw new RuntimeException("Product not found in cart");
        }
    }
}
