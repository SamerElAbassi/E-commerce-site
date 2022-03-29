package com.example.clothes.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class CartDto {
    private String username;
    private List<FullCartItemDto> cartItems;
    private float price;
}
