package com.example.clothes.controllers;

import com.example.clothes.enums.QueryOperator;
import com.example.clothes.enums.Sizes;
import com.example.clothes.exceptions.ProductNotFoundException;
import com.example.clothes.models.FilterQuery;
import com.example.clothes.models.Product;
import com.example.clothes.repositories.ProductRepository;
import com.example.clothes.services.ProductService;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.EnumUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("api/products")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final ProductRepository productRepository;


    @GetMapping("/{id}")
    public Product find(@PathVariable Long id) {
        return productService.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }

    @GetMapping
    List<Product> findAll() {
        return productService.findAll();
    }

    @PostMapping
    public Product add(@RequestBody Product product) {
        return productService.save(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@RequestBody Product product, @PathVariable Long id) {
        product.setId(id);
        return new ResponseEntity<>(productService.save(product), HttpStatus.OK);
    }


    @GetMapping("/filter")
    public List<Product> filter(@RequestParam Map<String, String> params) {
        List<FilterQuery> filters = new ArrayList<>();
        params.forEach((k, v) -> {
            if (v.contains("-")) {
                filters.add(new FilterQuery(k, QueryOperator.BETWEEN, "", FilterQuery.splitValues(v, "-")));
            } else {
                if (!k.equals("category") && !k.equals("sizes"))
                    filters.add(new FilterQuery(k, QueryOperator.IN, "", FilterQuery.splitValues(v, ",")));
            }
        });
        List<Product> filtered = productService.getQueryResult(filters);
        // this is really bad, but doesnt affect performance
        if (params.containsKey("category"))
            filtered = filtered.stream().filter(product -> product.getCategory().getName().equals(params.get("category"))).collect(Collectors.toList());
        if (params.containsKey("sizes")) {
            List<Sizes> sizes = Stream.of(params.get("sizes").split(",")).map(size -> EnumUtils.getEnum(Sizes.class, size)).collect(Collectors.toList());
            filtered = filtered.stream().filter(product ->
                    product.getSizes().containsAll(sizes)).collect(Collectors.toList());
        }
        return filtered;
    }

}
