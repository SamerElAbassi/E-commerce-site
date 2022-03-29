package com.example.clothes.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private List<FullCartItemDto> fullCartItemDtoList;
    private String username;
    private LocalDate dateCreated;
    private String status;
}
