package org.example.viberr.Mappers.Chat;

import org.example.viberr.DTO.Chat.ChatDTO;
import org.example.viberr.DTO.Chat.GroupChatDTO;
import org.example.viberr.DTO.Chat.PrivateChatDTO;
import org.example.viberr.Models.Chat.Chat;
import org.example.viberr.Models.Chat.GroupChat;
import org.example.viberr.Models.Chat.PrivateChat;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ChatMapper {

    default void updateChatFromDto(ChatDTO chatDto, Chat chat) {
        if (chatDto instanceof GroupChatDTO && chat instanceof GroupChat) {
            Mappers.getMapper(GroupChatMapper.class).updateChatFromDTO((GroupChatDTO) chatDto, (GroupChat) chat);
        } else if (chatDto instanceof PrivateChatDTO && chat instanceof PrivateChat) {
            Mappers.getMapper(PrivateChatMapper.class).updateChatFromDto((PrivateChatDTO) chatDto, (PrivateChat) chat);
        } else {
            throw new IllegalArgumentException("Invalid DTO");
        }
    }

    default void patchChatFromDto(ChatDTO chatDto, Chat chat) {
        if (chatDto instanceof GroupChatDTO && chat instanceof GroupChat) {
            Mappers.getMapper(GroupChatMapper.class).patchChatFromDTO((GroupChatDTO) chatDto, (GroupChat) chat);
        } else if (chatDto instanceof PrivateChatDTO && chat instanceof PrivateChat) {
            Mappers.getMapper(PrivateChatMapper.class).patchChatFromDto((PrivateChatDTO) chatDto, (PrivateChat) chat);
        } else {
            throw new IllegalArgumentException("Invalid DTO");
        }
    }

    default ChatDTO dtoFromChat(Chat chat) {
        if (chat instanceof GroupChat) {
            return Mappers.getMapper(GroupChatMapper.class).dtoFromChat((GroupChat) chat);
        } else if (chat instanceof PrivateChat) {
            return Mappers.getMapper(PrivateChatMapper.class).dtoFromChat((PrivateChat) chat);
        } else {
            throw new IllegalArgumentException("Unsupported chat type: " + chat.getClass());
        }
    }

    default Chat chatFromDTO(ChatDTO chatDto) {
        if (chatDto instanceof GroupChatDTO) {
            return Mappers.getMapper(GroupChatMapper.class).chatFromDto((GroupChatDTO) chatDto);
        } else if (chatDto instanceof PrivateChatDTO) {
            return Mappers.getMapper(PrivateChatMapper.class).chatFromDto((PrivateChatDTO) chatDto);
        } else {
            throw new IllegalArgumentException("Unsupported chat type: " + chatDto.getClass());
        }
    }

    default List<ChatDTO> dtoListFromChat(List<? extends Chat> chatList) {
        return chatList.stream()
                .map(this::dtoFromChat)
                .collect(Collectors.toList());
    }
}
