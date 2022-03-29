package com.example.clothes.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class UserDetailsImpl implements UserDetails {
    private Long id;
    private String userName;
    private String password;
    private boolean active;
    private String firstName;
    private String lastName;
    private List<GrantedAuthority> authorities;

    public UserDetailsImpl(User user) {
        this.id = user.getId();
        this.userName = user.getUsername();
        this.password = user.getPassword();
        this.active = user.isActive();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.authorities = Arrays.stream(user.getRoles().split(",")).
                map(SimpleGrantedAuthority::new).
                collect(Collectors.toList());

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "UserDetailsImpl{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", active=" + active +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", authorities=" + authorities +
                '}';
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
