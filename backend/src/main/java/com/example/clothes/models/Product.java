package com.example.clothes.models;

import com.example.clothes.enums.Sizes;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(columnDefinition = "text")
    private String img;
    private Double price;
    private String name;
    @Column(columnDefinition = "text")
    private String description;
    private String color;
    @ManyToOne
    @JoinColumn(name="category_id")
    @JsonIgnore
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Category category;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<Sizes> sizes;

}

