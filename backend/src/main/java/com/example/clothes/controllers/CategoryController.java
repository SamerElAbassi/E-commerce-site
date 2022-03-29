package com.example.clothes.controllers;

import com.example.clothes.models.Product;
import com.example.clothes.services.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/api/category/")
public class CategoryController {
    private CategoryService categoryService;
    @GetMapping("{name}")
    public ResponseEntity<List<Product>> findAll(@PathVariable String name){
        return new ResponseEntity<>(categoryService.findByName(name), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<String>> findAll(){
        return new ResponseEntity<>(categoryService.getAllNames(),HttpStatus.OK);
    }
}
