package org.example.viberr.DTO;

import lombok.Data;
import org.example.viberr.Enums.UserRole;

@Data
public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private String phone;
    private String password;
    private UserRole role;
    private Long profileId;
}
