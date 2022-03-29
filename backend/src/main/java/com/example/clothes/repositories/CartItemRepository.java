package com.example.clothes.repositories;

import com.example.clothes.models.Cart;
import com.example.clothes.models.CartItem;
import com.example.clothes.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem,Long> {

    List<CartItem> findByCart(Cart cart);

    CartItem findByProduct_Id(Long productId);
    @Transactional
    void deleteByProduct_Id(Long productId);

    boolean existsByProduct(Product product);

    CartItem findByProduct(Product product);

    void deleteByCart(Cart cart);
    @Transactional
    void deleteAllByCart_Id(Long cartId);
}
