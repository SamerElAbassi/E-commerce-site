package com.example.clothes.exceptions;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(Long id){
        super("Could not find product" + id);
    }
}
