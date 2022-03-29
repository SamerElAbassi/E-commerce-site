package com.example.clothes.services;

import com.example.clothes.models.Category;
import com.example.clothes.models.Product;
import com.example.clothes.repositories.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {
    private CategoryRepository categoryRepository;
    public List<Product> findByName(String name){
        Category category=categoryRepository.findByName(name);
        return category.getProducts();
    }
    public List<String> getAllNames(){
        return categoryRepository.getAllNames();
    }
}
