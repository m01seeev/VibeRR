package org.example.viberr.Models;

import lombok.Data;
import org.example.viberr.Enums.UserRole;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "users")
@Data
public class User {
    @Id
    private String id;
    private String username;
    private String email;
    private String password;
    private UserRole role;
    private String profileId;
    private List<String> contactsIds;
}
