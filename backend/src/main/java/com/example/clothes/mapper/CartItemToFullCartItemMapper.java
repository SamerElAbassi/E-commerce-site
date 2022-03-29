package com.example.clothes.mapper;

import com.example.clothes.dto.FullCartItemDto;
import com.example.clothes.models.CartItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CartItemToFullCartItemMapper {
    CartItemToFullCartItemMapper INSTANCE = Mappers.getMapper(CartItemToFullCartItemMapper.class);
    FullCartItemDto toFullCartItem(CartItem cartItem);

    List<FullCartItemDto> toFullCartItem(List<CartItem> cartItems);
}
