package org.example.viberr.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, name = "username")
    private String username;

    @Column(unique = true, nullable = true, name = "email")
    private String email;

    @Column(unique = true, nullable = true, name = "phone")
    private String phone;

    @Column(unique = true, nullable = false, name = "password")
    private String password;

    @Column(nullable = false, name = "role")
    private String role;
}
