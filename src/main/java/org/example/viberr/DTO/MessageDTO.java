package org.example.viberr.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MessageDTO {
    private String id;
    private Long senderId;
    private String chatId;
    private String text;
    private LocalDateTime timestamp;
    private Long forwardedFromId;
    private String replyToId;
}
