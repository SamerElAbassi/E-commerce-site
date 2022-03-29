package com.example.clothes.controllers;

import com.example.clothes.models.Order;
import com.example.clothes.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/api/orders/")
public class OrderController {
    private OrderService orderService;
    @GetMapping("{username}")
    ResponseEntity<List<Order>> findAll(@PathVariable String username){
        System.out.println(username);
        return new ResponseEntity<List<Order>>(orderService.findAllByUsername(username), HttpStatus.OK);
    }
}
