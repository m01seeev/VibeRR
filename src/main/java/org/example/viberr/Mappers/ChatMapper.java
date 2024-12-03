package org.example.viberr.Mappers;

import org.example.viberr.Enums.ChatType;
import org.example.viberr.Models.Chat.Chat;
import org.example.viberr.Models.Chat.GroupChat;
import org.example.viberr.Models.Chat.PrivateChat;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface ChatMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void patchGroupChatFromDto(GroupChat chatDetails, @MappingTarget GroupChat chat);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void patchPrivateChatFromDto(PrivateChat chatDetails, @MappingTarget PrivateChat chat);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
    void updateGroupChatFromDto(GroupChat chatDetails, @MappingTarget GroupChat chat);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
    void updatePrivateChatFromDto(PrivateChat chatDetails, @MappingTarget PrivateChat chat);

    default String chatTypeToString(ChatType chatType) {
        return chatType != null ? chatType.name() : null;
    }

    default ChatType stringToChatType(String chatType) {
        return chatType != null ? ChatType.valueOf(chatType.toUpperCase()) : null;
    }
}
