package com.example.clothes.models;
public class AuthenticationResponse {
    private String jwt;
    public void AuthenticationReponse(String jwt){
        this.jwt=jwt;
    }
    public String getJwt(){
        return jwt;
    }

}
