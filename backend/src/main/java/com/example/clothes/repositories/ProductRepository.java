package com.example.clothes.repositories;

import com.example.clothes.enums.Sizes;
import com.example.clothes.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long>, JpaSpecificationExecutor<Product> {
    List<Product> findAllByNameIgnoreCase(String name);
    List <Product> findByNameInIgnoreCase(List <String> names);


    List<Product> findAllBySizesIn(List<Sizes> realSizes);
}
