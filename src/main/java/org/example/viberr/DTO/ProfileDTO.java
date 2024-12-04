package org.example.viberr.DTO;

import lombok.Data;
import org.example.viberr.Enums.ProfileStatus;

import java.time.LocalDate;

@Data
public class ProfileDTO {
    private Long id;
    private String name;
    private String surname;
    private String patronymic;
    private LocalDate birthDate;
    private String picRef;
    private String location;
    private ProfileStatus status;
}
