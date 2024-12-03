package org.example.viberr.Models.Chat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Data;
import org.example.viberr.Enums.ChatType;

import java.time.LocalDateTime;

@Data
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "chatType", visible = false)
@JsonSubTypes({
        @JsonSubTypes.Type(value = GroupChat.class, name = "GROUP"),
        @JsonSubTypes.Type(value = PrivateChat.class, name = "PRIVATE")
})
public abstract class Chat {
    @Id
    private String id;
    @Enumerated(EnumType.STRING)
    @JsonIgnore
    private ChatType chatType;
    private LocalDateTime lastMessage;
}
