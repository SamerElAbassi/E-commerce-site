package com.example.clothes.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private String username;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "order")
    private List<OrderItem> orderItems;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateCreated;

    private String status;
    private Float price;

}
