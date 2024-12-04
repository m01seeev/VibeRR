package org.example.viberr.Mappers;

import org.example.viberr.Enums.ChatType;
import org.example.viberr.Models.Chat.GroupChat;
import org.example.viberr.Models.Chat.PrivateChat;
import org.mapstruct.*;


@Mapper(componentModel = "spring")
public interface ChatMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
    @Mapping(target = "id", ignore = true)
    void updateGroupChatFromDto(GroupChat chatDetails, @MappingTarget GroupChat chat);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
    @Mapping(target = "id", ignore = true)
    void updatePrivateChatFromDto(PrivateChat chatDetails, @MappingTarget PrivateChat chat);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void patchGroupChatFromDto(GroupChat chatDetails, @MappingTarget GroupChat chat);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void patchPrivateChatFromDto(PrivateChat chatDetails, @MappingTarget PrivateChat chat);

    default String chatTypeToString(ChatType chatType) {
        return chatType != null ? chatType.name() : null;
    }

    default ChatType stringToChatType(String chatType) {
        return chatType != null ? ChatType.valueOf(chatType.toUpperCase()) : null;
    }
}
