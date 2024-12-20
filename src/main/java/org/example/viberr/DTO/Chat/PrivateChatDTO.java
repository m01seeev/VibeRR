package org.example.viberr.DTO.Chat;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class PrivateChatDTO extends ChatDTO {
    private String user1Id;
    private String user2Id;
}
