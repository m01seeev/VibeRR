package org.example.viberr.Mappers;

import org.example.viberr.Enums.ChatType;
import org.example.viberr.Models.Chat.Chat;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface ChatMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void patchChatFromDto(Chat chatDetails, @MappingTarget Chat chat);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
    void updateChatFromDto(Chat chatDetails, @MappingTarget Chat chat);

    default String chatTypeToString(ChatType chatType) {
        return chatType != null ? chatType.name() : null;
    }

    default ChatType stringToChatType(String chatType) {
        return chatType != null ? ChatType.valueOf(chatType.toUpperCase()) : null;
    }
}
