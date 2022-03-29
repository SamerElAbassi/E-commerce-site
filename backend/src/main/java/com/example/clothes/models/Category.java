package com.example.clothes.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity(name="category")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToMany(fetch=FetchType.EAGER,mappedBy = "category")
    private List<Product> products;
    private String name;

}
