package org.example.viberr.Models;

import jakarta.persistence.*;
import lombok.Data;
import org.example.viberr.Enums.ProfileStatus;

import java.time.LocalDate;

@Entity
@Table(name = "profiles")
@Data
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, name = "name")
    private String name;
    @Column(nullable = false, name = "surname")
    private String surname;
    @Column(name = "patronimyc")
    private String patronymic;
    @Column(name = "birthDate")
    private LocalDate birthDate;
    @Column(name = "pic_ref")
    private String pic_ref;
    @Column(name = "location")
    private String location;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "status")
    private ProfileStatus status;
}
