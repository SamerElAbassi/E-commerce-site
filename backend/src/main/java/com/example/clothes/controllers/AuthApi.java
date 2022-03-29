package com.example.clothes.controllers;

import com.example.clothes.dto.HiddenUserView;
import com.example.clothes.mapper.SignupRequestToUserMapper;
import com.example.clothes.models.AuthenticationRequest;
import com.example.clothes.models.SignupRequest;
import com.example.clothes.security.JwtTokenUtil;
import com.example.clothes.security.User;
import com.example.clothes.security.UserDetailsImpl;
import com.example.clothes.services.UserDetailsServiceImpl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "api/")
public class AuthApi {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private UserDetailsImpl userDetails;
    private SignupRequestToUserMapper signupRequestToUserMapper;
    private UserDetailsServiceImpl userDetailsService;
    public AuthApi(AuthenticationManager authenticationManager,
                   JwtTokenUtil jwtTokenUtil,SignupRequestToUserMapper signupRequestToUserMapper,UserDetailsServiceImpl userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.signupRequestToUserMapper=signupRequestToUserMapper;
        this.userDetailsService=userDetailsService;
    }

    @PostMapping("login")
    public ResponseEntity<HiddenUserView> login(@RequestBody @Valid AuthenticationRequest request) {

        try {
            Authentication authenticate = authenticationManager
                    .authenticate(
                            new UsernamePasswordAuthenticationToken(
                                    request.getUsername(), request.getPassword()
                            )
                    );
            UserDetailsImpl user = (UserDetailsImpl) authenticate.getPrincipal();
            String token = jwtTokenUtil.generateAccessToken(user);

            HiddenUserView userData = HiddenUserView.builder()
                    .firstname(user.getFirstName())
                    .lastname(user.getLastName())
                    .token(token)
                    .username(user.getUsername())
                    .build();

            return ResponseEntity.ok()
                    .header(
                            HttpHeaders.AUTHORIZATION,
                            token
                    )
                    .body(userData);
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
    @PostMapping("signup/")
    public ResponseEntity signup(@RequestBody @Valid SignupRequest request){
        User user= signupRequestToUserMapper.toUser(request);
        user.setRoles("user");
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userDetailsService.add(user);
        return ResponseEntity.noContent().build();
    }
}
