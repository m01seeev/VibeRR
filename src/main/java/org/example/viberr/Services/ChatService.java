package org.example.viberr.Services;

import lombok.RequiredArgsConstructor;
import org.example.viberr.Mappers.ChatMapper;
import org.example.viberr.Models.Chat.Chat;
import org.example.viberr.Repositories.ChatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final ChatRepository chatRepository;
    private final ChatMapper chatMapper;

    public List<Chat> finAll() {
        return chatRepository.findAll();
    }

    public Chat findById(String id) {
        return chatRepository.findById(id).orElse(null);
    }

    public Chat save(Chat chat) {
        return chatRepository.save(chat);
    }

    public Chat update(String id, Chat chatDetails) {
        Chat chat = findById(id);
        chatMapper.updateChatFromDto(chatDetails, chat);
        chat.setId(id);
        return chatRepository.save(chat);
    }

    public Chat patch(String id, Chat chatDetails) {
        Chat chat = findById(id);
        chatMapper.patchChatFromDto(chatDetails, chat);
        return chatRepository.save(chat);
    }

    public void delete(String id) {
        chatRepository.deleteById(id);
    }

}
