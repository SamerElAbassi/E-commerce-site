package com.example.clothes.services;

import com.example.clothes.models.Cart;
import com.example.clothes.repositories.CartRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CartService {
    private CartRepository cartRepository;

    public Cart findByUsername(String username) {
        Cart cart= cartRepository.findByUsername(username);
        if (cart==null) {
            cart=new Cart();
            cart.setUsername(username);
            cartRepository.save(cart);

        }
        return cart;
    }
    public void deleteByUsername(String username){
        Cart cart=cartRepository.findByUsername(username);
        cartRepository.deleteByUsername(username);
    }
    public void save(Cart cart){
        cartRepository.save(cart);
    }
}
