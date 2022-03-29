package com.example.clothes.repositories;

import com.example.clothes.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {
    Cart findByUsername(String userName);
    @Transactional
    void deleteByUsername(String username);
}
