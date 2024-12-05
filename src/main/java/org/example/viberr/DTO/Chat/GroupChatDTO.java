package org.example.viberr.DTO.Chat;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class GroupChatDTO extends ChatDTO {
    private String groupName;
    private String groupPicRef;
    private List<Long> membersIds;
}
