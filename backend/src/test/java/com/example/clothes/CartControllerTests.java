package com.example.clothes;

import com.example.clothes.dto.CartItemDto;
import com.example.clothes.enums.Sizes;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class CartControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Add to cart")
    @WithMockUser("admin")
    void addToCart() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        CartItemDto cartDto = CartItemDto.builder()
                .productId(50L)
                .quantity(20)
                .size(Sizes.S)
                .build();
        String json = objectMapper.writeValueAsString(cartDto);
        final int status = mockMvc.perform
                        (post("/api/cart/add")
                                .contentType(MediaType.APPLICATION_JSON)
                                .characterEncoding("utf-8")
                                .content(json))
                .andReturn().getResponse().getStatus();
        assertEquals(201, status);
    }
    @Test
    @WithMockUser("admin")
    void deleteById() throws Exception{
        final int status = mockMvc.perform
                        (delete("/api/cart/delete/{id}","50"))
                .andReturn().getResponse().getStatus();
        assertEquals(204, status);
    }
    @Test
    @WithMockUser("admin")
    void deleteCart() throws Exception{
        final int status = mockMvc.perform
                        (delete("/api/cart/"))
                .andReturn().getResponse().getStatus();
        assertEquals(204, status);
    }
}
