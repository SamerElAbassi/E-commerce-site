package com.example.clothes.models;

import com.example.clothes.enums.Sizes;
import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;

@Entity(name="cart_item")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", product=" + product +
                ", quantity=" + quantity +
                '}';
    }

    @OneToOne(fetch = FetchType.EAGER)
    private Product product;
    private int quantity;
    @Enumerated(EnumType.STRING)
    private Sizes size;
    @ManyToOne
    @JoinColumn(name="cart_id")
    @JsonIgnore
    private Cart cart;
    @Override
    public int hashCode(){
        return product.getId().intValue();
    }
}
