package com.pkge.app.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Column(name = "user_name")
    private String username;
    private String password;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    private String role;
    private String status;

}
