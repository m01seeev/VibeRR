package org.example.viberr.Models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "messages")
public class Message {
    @Id
    private String id;
    private String senderId;
    private String chatId;
    private String text;
    private LocalDateTime timestamp;
    private String forwardedFromId;
    private String replyToId;
}
