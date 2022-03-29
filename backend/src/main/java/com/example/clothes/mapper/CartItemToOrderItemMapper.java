package com.example.clothes.mapper;

import com.example.clothes.models.CartItem;
import com.example.clothes.models.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CartItemToOrderItemMapper {
    CartItemToOrderItemMapper INSTANCE = Mappers.getMapper(CartItemToOrderItemMapper.class);
    OrderItem toOrderItem(CartItem cartItem);

    List<OrderItem> toOrderItem(List<CartItem> cartItems);
}
