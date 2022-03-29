package com.example.clothes.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SignupRequest {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private boolean isActive;


}
