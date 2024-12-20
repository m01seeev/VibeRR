package org.example.viberr.Models;

import lombok.Data;
import org.example.viberr.Enums.ProfileStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "profiles")
@Data
public class Profile {
    @Id
    private String id;
    private String name;
    private String surname;
    private String patronymic;
    private LocalDate birthDate;
    private String picRef;
    private String location;
    private ProfileStatus status;
}
