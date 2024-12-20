package org.example.viberr.Models.Chat;

import lombok.Data;
import org.example.viberr.Enums.ChatType;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
public abstract class Chat {
    @Id
    private String id;
    private ChatType type;
    private LocalDateTime lastMessage;
}
