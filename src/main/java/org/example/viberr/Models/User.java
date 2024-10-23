package org.example.viberr.Models;

import jakarta.persistence.*;
import lombok.Data;
import org.example.viberr.Enums.Role;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false, name = "username")
    private String username;
    @Column(unique = true, name = "email")
    private String email;
    @Column(unique = true, name = "phone")
    private String phone;
    @Column(nullable = false, name = "password")
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "role")
    private Role role;
    @OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    private Profile profile;
}
