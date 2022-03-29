package com.example.clothes.controllers;

import com.example.clothes.dto.CartDto;
import com.example.clothes.dto.CartItemDto;
import com.example.clothes.dto.FullCartItemDto;
import com.example.clothes.mapper.CartItemDtoMapper;
import com.example.clothes.mapper.CartItemToFullCartItemMapper;
import com.example.clothes.models.Cart;
import com.example.clothes.models.CartItem;
import com.example.clothes.models.Product;
import com.example.clothes.services.CartItemService;
import com.example.clothes.services.CartService;
import com.example.clothes.services.OrderService;
import com.example.clothes.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/api/cart/")
public class CartController {

    private CartItemService cartItemService;
    private ProductService productService;
    private CartService cartService;
    private CartItemDtoMapper cartItemDtoMapper;
    private CartItemToFullCartItemMapper cartItemToFullCartItemMapper;
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<CartDto> getAll() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        Cart cart = cartService.findByUsername(userDetails.getUsername());
        List<FullCartItemDto> cartItemDtos = cartItemToFullCartItemMapper.toFullCartItem(cart.getCartItems());
        CartDto cartDto = CartDto.builder()
                .cartItems(cartItemDtos)
                .price(cart.getPrice())
                .username(cart.getUsername())
                .build();
        return new ResponseEntity<>(cartDto, HttpStatus.OK);
    }

    @PostMapping(path = "add")
    public ResponseEntity<CartItemDto> addProduct(@RequestBody CartItemDto cartItemDto) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();

        Product product = productService.findById(cartItemDto.getProductId()).orElseThrow();
        CartItem cartItem = cartItemService.findByProduct(product);
        if (cartItem == null)
            cartItemService.addItem(product, cartItemDto.getQuantity(), cartItemDto.getSize(), userDetails.getUsername());
        else cartItemService.update(cartItemDto.builder()
                .productId(cartItem.getProduct().getId())
                .quantity(cartItem.getQuantity() + 1)
                .size(cartItemDto.getSize())
                .build());
        return new ResponseEntity<CartItemDto>(cartItemDto, HttpStatus.CREATED);
    }
    @GetMapping(path="{id}")
    public ResponseEntity<FullCartItemDto> findById( @PathVariable Long id){
        return new ResponseEntity<>(cartItemToFullCartItemMapper.toFullCartItem(cartItemService.findByProduct_id(id)),HttpStatus.OK);
    }
    @DeleteMapping()
    public ResponseEntity<List<FullCartItemDto>> deleteCart() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        cartService.deleteByUsername(userDetails.getUsername());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(path = "update")
    public ResponseEntity<FullCartItemDto> updateProduct( @RequestBody CartItemDto cartItemDto) {
        return new ResponseEntity<FullCartItemDto>(cartItemToFullCartItemMapper.toFullCartItem(cartItemService.update(cartItemDto)), HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteProduct( @PathVariable int id) {
        cartItemService.delete(Long.valueOf(id));
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
    @PostMapping
    public ResponseEntity placeOrder(){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        Cart cart = cartService.findByUsername(userDetails.getUsername());
        orderService.create(cart);
        cartItemService.deleteByCart(cart);
        return  ResponseEntity.ok().build();
    }
}
