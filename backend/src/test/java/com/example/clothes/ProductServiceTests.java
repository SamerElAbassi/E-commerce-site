package com.example.clothes;

import com.example.clothes.enums.Sizes;
import com.example.clothes.models.Category;
import com.example.clothes.models.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class ProductServiceTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Adding mock product")
    void add() throws Exception {
        Product product = Product.builder()
                .color("red")
                .description("Description")
                .img("img")
                .sizes(List.of(Sizes.S))
                .name("Puffer")
                .price(5.22)
                .build();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(product);
        final String response = mockMvc.perform
                        (post("/api/products/")
                                .contentType(MediaType.APPLICATION_JSON)
                                .characterEncoding("utf-8")
                                .content(json))
                .andReturn().getResponse().getContentAsString();
        Product responseProduct=objectMapper.readValue(response,Product.class);
        assertThat(responseProduct).usingRecursiveComparison().ignoringFields("id").isEqualTo(product);
    }
    @Test
    @DisplayName("Update product by id")
    void updateById() throws  Exception {
        Product product = Product.builder()
                .id(100L)
                .color("red")
                .description("Description")
                .img("img")
                .sizes(List.of(Sizes.S))
                .name("Puffer")
                .price(5.22)
                .category(Category.builder().name("Puffers").build())
                .build();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(product);
        final String response = mockMvc.perform
                        (put("/api/products/{id}",100)
                                .contentType(MediaType.APPLICATION_JSON)
                                .characterEncoding("utf-8")
                                .content(json))
                .andReturn().getResponse().getContentAsString();
        Product responseProduct=objectMapper.readValue(response,Product.class);
        assertThat(responseProduct).usingRecursiveComparison().ignoringFields("category").isEqualTo(product);

    }
}
