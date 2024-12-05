package org.example.viberr.Services;

import lombok.RequiredArgsConstructor;
import org.example.viberr.DTO.Chat.ChatDTO;
import org.example.viberr.Mappers.Chat.ChatMapper;
import org.example.viberr.Models.Chat.Chat;
import org.example.viberr.Repositories.ChatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final ChatRepository chatRepository;
    private final ChatMapper chatMapper;

    public List<ChatDTO> findAll() {
        return chatMapper.dtoListFromChat(chatRepository.findAll());
    }

    public ChatDTO findById(String id) {
        return chatMapper.dtoFromChat(chatRepository.findById(id).orElse(null));
    }

    public ChatDTO save(ChatDTO chatDto) {
        Chat chat = chatMapper.chatFromDTO(chatDto);
        chatRepository.save(chat);
        return chatMapper.dtoFromChat(chat);
    }

    public ChatDTO update(String id, ChatDTO chatDto) {
        Chat chat = chatRepository.findById(id).orElse(null);
        chatMapper.updateChatFromDto(chatDto, chat);
        assert chat != null;
        chatRepository.save(chat);
        return chatMapper.dtoFromChat(chat);
    }

    public ChatDTO patch(String id, ChatDTO chatDto) {
        Chat chat = chatRepository.findById(id).orElse(null);
        chatMapper.patchChatFromDto(chatDto, chat);
        assert chat != null;
        chatRepository.save(chat);
        return chatMapper.dtoFromChat(chat);
    }

    public void delete(String id) {
        chatRepository.deleteById(id);
    }
}
