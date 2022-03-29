package com.example.clothes.configs;

import com.example.clothes.repositories.UserRepository;
import com.example.clothes.security.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Configuration
public class UserDataConfig implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        loadUserData();
    }

    private void loadUserData() {
//        User user1 = User.builder()
//                .username("admin")
//                .password(new BCryptPasswordEncoder().encode("pass"))
//                .firstName("Samer")
//                .lastName("El Abassi")
//                .active(true)
//                .roles("admin,user")
//                .build();
//        User user2 = User.builder()
//                .username("user")
//                .password(new BCryptPasswordEncoder().encode("pass"))
//                .firstName("Andreea")
//                .lastName("Mantea")
//                .active(true)
//                .roles("user")
//                .build();
//        System.out.println("here");
//        try {
//            userRepository.save(user1);
//        } catch (Exception e){
//            System.out.println(e);
//        };
//        try {
//            userRepository.save(user2);
//        } catch (Exception e){
//            System.out.println(e);
//        }
    }
}

