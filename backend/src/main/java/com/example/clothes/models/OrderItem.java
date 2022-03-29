package com.example.clothes.models;

import com.example.clothes.enums.Sizes;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;

@Entity(name="order_item")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    private Product product;
    private int quantity;
    @Enumerated(EnumType.STRING)
    private Sizes size;
    @ManyToOne
    @JoinColumn(name="order_id")
    @JsonIgnore
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Order order;
}
