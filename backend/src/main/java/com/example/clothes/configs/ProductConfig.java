package com.example.clothes.configs;

import com.example.clothes.services.ProductService;
import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfig {
    @Bean
    CommandLineRunner initDatabase(ProductService productService) {


        return args -> {
            Lorem lorem = LoremIpsum.getInstance();

//            System.out.println("Here");
//            productService.add(
//                    Product.builder()
//                            .name("Portocale")
//                            .price(3.19)
//                            .img("https://th.bing.com/th/id/R.2028eb6504484e8055b28e8604620b18?rik=Ev4rZNNTu2zjxA&pid=ImgRaw&r=0")
//                            .brand("Moschino")
//                            .description(lorem.getWords(10, 15))
//                            .sizes(List.of(Sizes.values()))
//                            .reviews(2.19)
//                            .build());
//            productService.add(
//                    Product.builder()
//                            .name("Rosii")
//                            .price(5.11)
//                            .img("https://th.bing.com/th/id/R.2028eb6504484e8055b28e8604620b18?rik=Ev4rZNNTu2zjxA&pid=ImgRaw&r=0")
//                            .brand("Moschino")
//                            .description(lorem.getWords(10, 15))
//                            .reviews(2.15)
//                            .sizes(List.of(Sizes.values()))
//                            .build());
//            productService.add(
//                    Product.builder()
//                            .name("Afine")
//                            .price(4.92)
//                            .img("https://th.bing.com/th/id/R.2028eb6504484e8055b28e8604620b18?rik=Ev4rZNNTu2zjxA&pid=ImgRaw&r=0")
//                            .brand("Moschino")
//                            .description(lorem.getWords(10, 15))
//                            .reviews(2.35)
//                            .sizes(List.of(Sizes.values()))
//                            .build());
//            productService.add(
//                    Product.builder()
//                            .name("Rosii")
//                            .price(2.19)
//                            .img("https://th.bing.com/th/id/R.2028eb6504484e8055b28e8604620b18?rik=Ev4rZNNTu2zjxA&pid=ImgRaw&r=0")
//                            .brand("Moschino")
//                            .description(lorem.getWords(10, 15))
//                            .reviews(2.85)
//                            .sizes(List.of(Sizes.values()))
//                            .build());
//            productService.add(new Product(
//                    "Portocale",
//                    1.39,
//                    1.92,
//                    "https://th.bing.com/th/id/R.2028eb6504484e8055b28e8604620b18?rik=Ev4rZNNTu2zjxA&pid=ImgRaw&r=0",));
//            productService.add(new Product(
//                    "Rosii",
//                    5.39,
//                    3.25,
//                    "https://th.bing.com/th/id/R.93057b11296071efd07c03c0e98d9cf3?rik=89Xuq6HQYs%2fUgA&riu=http%3a%2f%2fcdn1.shopmania.biz%2ffiles%2fs4%2f592978066%2fp%2fl%2f4%2frosii-final-f1-500-sem-seminte-de-rosii-semideterminate-florian%7e1964.jpg&ehk=BwAcPBmXDaQmIJeahjRmPrbKbxB0NU0wSvK8rsoLEzw%3d&risl=&pid=ImgRaw&r=0",
//                    lorem.getWords(5,10),
//                    "Zara",
//                    Sizes.S));
//            productService.add(new Product(
//                    "Portocale",
//                    4.39,
//                    5.21,
//                    "https://th.bing.com/th/id/R.2028eb6504484e8055b28e8604620b18?rik=Ev4rZNNTu2zjxA&pid=ImgRaw&r=0", ));
//            productService.add(new Product(
//                    "Portocale",
//                    5.39,
//                    3.25,
//                    "https://th.bing.com/th/id/R.2028eb6504484e8055b28e8604620b18?rik=Ev4rZNNTu2zjxA&pid=ImgRaw&r=0", ));

        }
                ;

    }
}


