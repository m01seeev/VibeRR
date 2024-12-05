package org.example.viberr.Mappers.Chat;

import org.example.viberr.DTO.Chat.PrivateChatDTO;
import org.example.viberr.Models.Chat.PrivateChat;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface PrivateChatMapper {
    PrivateChatDTO dtoFromChat(PrivateChat chat);

    PrivateChat chatFromDto(PrivateChatDTO dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
    @Mapping(target = "id", ignore = true)
    void updateChatFromDto(PrivateChatDTO chatDto, @MappingTarget PrivateChat chat);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void patchChatFromDto(PrivateChatDTO chatDto, @MappingTarget PrivateChat chat);
}
