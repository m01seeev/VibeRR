package org.example.viberr.Models.Chat;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Data;
import org.example.viberr.Enums.ChatType;

import java.time.LocalDateTime;

@Data
public abstract class Chat {
    @Id
    private String id;
    @Enumerated(EnumType.STRING)
    private ChatType type;
    private LocalDateTime lastMessage;
}
