package com.example.clothes.repositories;

import com.example.clothes.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    Category findByName(String name);
    @Query("select c.name from category c")
    List<String> getAllNames();
}
