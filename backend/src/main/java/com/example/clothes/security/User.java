package com.example.clothes.security;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String firstName;
    // TODO change nullable
    private String lastName;
    private boolean active;
    private String roles;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", active=" + active +
                ", roles='" + roles + '\'' +
                '}';
    }


}