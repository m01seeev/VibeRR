package org.example.viberr.DTO.Chat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import org.example.viberr.Enums.ChatType;


import java.time.LocalDateTime;

@Data
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = false)
@JsonSubTypes({
        @JsonSubTypes.Type(value = GroupChatDTO.class, name = "GROUP"),
        @JsonSubTypes.Type(value = PrivateChatDTO.class, name = "PRIVATE")
})
public abstract class ChatDTO {
    private String id;
    @JsonIgnore
    private ChatType type;
    private LocalDateTime lastMessage;
}
