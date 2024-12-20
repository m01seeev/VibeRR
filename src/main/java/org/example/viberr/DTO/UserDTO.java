package org.example.viberr.DTO;

import lombok.Data;
import org.example.viberr.Enums.UserRole;

import java.util.List;

@Data
public class UserDTO {
    private String id;
    private String username;
    private String email;
    private String password;
    private UserRole role;
    private String profileId;
    private List<String> contactsIds;
}
