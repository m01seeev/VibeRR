package org.example.viberr.Mappers;

import org.example.viberr.DTO.MessageDTO;
import org.example.viberr.Models.Message;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MessageMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
    @Mapping(target = "id", ignore = true)
    void updateMessageFromDto(MessageDTO messageDto, @MappingTarget Message message);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void patchMessageFromDto(MessageDTO messageDto, @MappingTarget Message message);

    MessageDTO dtoFromMessage(Message message);

    Message messageFromDto(MessageDTO messageDto);

    List<MessageDTO> dtoListFromMessage(List<Message> messageList);

    List<Message> messageListFromDto(List<MessageDTO> messageDtoList);
}
