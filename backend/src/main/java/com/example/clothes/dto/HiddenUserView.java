package com.example.clothes.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class HiddenUserView {
    private String token;
    private String firstname;
    private String lastname;
    private String username;

}
