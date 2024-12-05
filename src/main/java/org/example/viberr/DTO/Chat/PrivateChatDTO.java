package org.example.viberr.DTO.Chat;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class PrivateChatDTO extends ChatDTO {
    private Long user1Id;
    private Long user2Id;
}
