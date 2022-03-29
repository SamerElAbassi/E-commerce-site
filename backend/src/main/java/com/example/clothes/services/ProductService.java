package com.example.clothes.services;

import com.example.clothes.models.FilterQuery;
import com.example.clothes.models.FilterableProductRepository;
import com.example.clothes.models.Product;
import com.example.clothes.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private FilterableProductRepository filterableProductRepository;



    public List<Product> findAll(){
        return productRepository.findAll();
    }
    public Product save(Product product){
        return productRepository.save(product);
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }
    public List<Product> findAllByName(String name){
        return productRepository.findAllByNameIgnoreCase(name);
    }

    public List <Product> findByNameIn(List<String> names) {
        return productRepository.findByNameInIgnoreCase(names);
    }
    public List<Product> getQueryResult(List<FilterQuery> filters){
        return this.filterableProductRepository.getQueryResult(filters);
    }


}
