package org.example.viberr.Models.Chat;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Data
@EqualsAndHashCode(callSuper = true)
@Document(collection = "chats")
public class GroupChat extends Chat {
    private String groupName;
    private String groupPicRef;
    private List<String> membersIds;
    public String leaderId;
}

