package com.ecommerce.ecommerse.Repo;

import com.ecommerce.ecommerse.Models.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepo extends JpaRepository<CartItem, Integer> {
//    public CartItem findByCartIdAndProductId(int id,int productId);
}
