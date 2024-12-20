package org.example.viberr.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MessageDTO {
    private String id;
    private String senderId;
    private String chatId;
    private String text;
    private LocalDateTime timestamp;
    private String forwardedFromId;
    private String replyToId;
}
