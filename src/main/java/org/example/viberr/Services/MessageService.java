package org.example.viberr.Services;

import lombok.RequiredArgsConstructor;
import org.example.viberr.Mappers.MessageMapper;
import org.example.viberr.Models.Message;
import org.example.viberr.Repositories.MessageRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;

    public List<Message> findAll() {
        return messageRepository.findAll();
    }

    public Message findById(String id) {
        return messageRepository.findById(id).orElse(null);
    }

    public Message save(Message message) {
        message.setTimestamp(LocalDateTime.now());
        return messageRepository.save(message);
    }

    public Message update(String id, Message messageDetails) {
        Message message = findById(id);
        messageMapper.updateMessageFromDto(messageDetails, message);
        message.setId(id);
        return messageRepository.save(message);
    }

    public Message patch(String id, Message messageDetails) {
        Message message = findById(id);
        messageMapper.patchMessageFromDto(messageDetails, message);
        return messageRepository.save(message);
    }

    public void delete(String id) {
        messageRepository.deleteById(id);
    }
}
