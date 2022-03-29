package com.example.clothes.mapper;

import com.example.clothes.dto.CartItemDto;
import com.example.clothes.models.CartItem;
import com.example.clothes.models.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CartItemDtoMapper {
    CartItemDtoMapper INSTANCE = Mappers.getMapper(CartItemDtoMapper.class);
    @Mapping(target="productId", source="product.id")
    CartItemDto toItemDto(CartItem cartItem);
    List<CartItemDto> toItemDto(List<CartItem> cartItems);
    default Long mapToProductId(Product product){
        return product.getId();
    }
}
