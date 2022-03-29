package com.example.clothes.dto;

import com.example.clothes.enums.Sizes;
import com.example.clothes.models.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FullCartItemDto {
    private Product product;
    private int quantity;
    private Sizes size;
}
