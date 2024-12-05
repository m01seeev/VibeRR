package org.example.viberr.Mappers.Chat;

import org.example.viberr.DTO.Chat.GroupChatDTO;
import org.example.viberr.Models.Chat.GroupChat;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface GroupChatMapper {
    GroupChatDTO dtoFromChat(GroupChat chat);

    GroupChat chatFromDto(GroupChatDTO chatDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
    @Mapping(target = "id", ignore = true)
    void updateChatFromDTO(GroupChatDTO chatDto, @MappingTarget GroupChat chat);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void patchChatFromDTO(GroupChatDTO chatDto, @MappingTarget GroupChat chat);
}
