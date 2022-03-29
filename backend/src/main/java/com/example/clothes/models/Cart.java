package com.example.clothes.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity(name="cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String username;

    @Override
    public String toString() {
        String result="Cart{" +
                "id=" + id +
                ", token='" + username + '\'' +
                ", cartItems=[";
        for (CartItem item:cartItems) result += item.toString();
        result +="]";
        return result;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="cart_id")
    private List<CartItem> cartItems;

    @Transient
    private Float price;

    public float getPrice(){
        float price=0;
        for (CartItem cartItem : cartItems) {
            price += cartItem.getProduct().getPrice() * cartItem.getQuantity();
        }
        return price;
    }

}
