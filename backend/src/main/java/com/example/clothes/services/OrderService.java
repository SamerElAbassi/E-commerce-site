package com.example.clothes.services;

import com.example.clothes.models.Cart;
import com.example.clothes.models.CartItem;
import com.example.clothes.models.Order;
import com.example.clothes.models.OrderItem;
import com.example.clothes.repositories.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {
    private OrderRepository orderRepository;

    public Order create(Cart cart){
        Order order= Order.builder()
                .dateCreated(LocalDate.now())
                .username(cart.getUsername())
                .price(cart.getPrice())
                .status("Created")
                .build();
        Order savedOrder = orderRepository.save(order);
        List <OrderItem> orderItems= new ArrayList<>();
        for (CartItem cartItem : cart.getCartItems()){
            orderItems.add(
                    OrderItem.builder()
                            .product(cartItem.getProduct())
                            .size(cartItem.getSize())
                            .quantity(cartItem.getQuantity())
                            .order(savedOrder)
                            .build()
            );
        }
        savedOrder.setOrderItems(orderItems);
        return orderRepository.save(savedOrder);
    }
    public List<Order> findAllByUsername(String username){
        return orderRepository.findAllByUsername(username);
    }
}
