package com.example.clothes.mapper;

import com.example.clothes.dto.FullCartItemDto;
import com.example.clothes.models.CartItem;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface FullCartItemToCartItemMapper {
    FullCartItemToCartItemMapper INSTANCE = Mappers.getMapper(FullCartItemToCartItemMapper.class);
    CartItem toFullCartItem(FullCartItemDto fullCartItemDto);

    List<CartItem> toFullCartItem(List<FullCartItemDto> fullCartItemDtos);
}
