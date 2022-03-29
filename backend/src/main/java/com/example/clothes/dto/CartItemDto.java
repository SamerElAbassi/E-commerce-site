package com.example.clothes.dto;

import com.example.clothes.enums.Sizes;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class CartItemDto {
    private Long productId;
    private int quantity;
    private Sizes size;
        @Override
    public int hashCode(){
        return productId.intValue();
    }


}
