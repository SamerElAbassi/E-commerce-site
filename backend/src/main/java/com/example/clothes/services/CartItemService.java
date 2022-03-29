package com.example.clothes.services;

import com.example.clothes.dto.CartItemDto;
import com.example.clothes.enums.Sizes;
import com.example.clothes.models.Cart;
import com.example.clothes.models.CartItem;
import com.example.clothes.models.Product;
import com.example.clothes.repositories.CartItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CartItemService {
    private CartItemRepository cartItemRepository;
    private CartService cartService;

    public List<CartItem> findByCart(Cart cart) {
        return cartItemRepository.findByCart(cart);
    }

    public String addItem(Product product, int quantity, Sizes size, String token) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        Cart cart = cartService.findByUsername(userDetails.getUsername());
        CartItem cartItem = CartItem.builder().product(product).quantity(quantity).size(size).cart(cart).build();
        cartItemRepository.save(cartItem);
        return cartItem.toString();
    }

    public CartItem update(CartItemDto cartItemDto) {
        CartItem cartItem=cartItemRepository.findByProduct_Id(cartItemDto.getProductId());
        cartItem.setQuantity(cartItemDto.getQuantity());
        if (cartItemDto.getSize()!=null)
            cartItem.setSize(cartItemDto.getSize());
        cartItemRepository.save(cartItem);
        return cartItem;
    }

    public void delete(Long productId) {
        cartItemRepository.deleteByProduct_Id(productId);

    }


    public boolean existsByProduct(Product product) {
        return cartItemRepository.existsByProduct(product);
    }

    public CartItem findByProduct(Product product) {
        return cartItemRepository.findByProduct(product);
    }

    public CartItem findByProduct_id(Long id) {
        return cartItemRepository.findByProduct_Id(id);
    }

    public void deleteByCart(Cart cart) {
        cartItemRepository.deleteAllInBatch(cart.getCartItems());
    }
}
