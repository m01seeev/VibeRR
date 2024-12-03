package org.example.viberr.Models.Chat;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@EqualsAndHashCode(callSuper = true)
@Document(collection = "chats")
public class PrivateChat extends Chat {
    private Long user1Id;
    private Long user2Id;
}

