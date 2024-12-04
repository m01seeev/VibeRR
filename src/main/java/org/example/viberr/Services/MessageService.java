package org.example.viberr.Services;

import lombok.RequiredArgsConstructor;
import org.example.viberr.DTO.MessageDTO;
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

    public List<MessageDTO> findAll() {
        return messageMapper.dtoListFromMessage(messageRepository.findAll());
    }

    public MessageDTO findById(String id) {
        return messageMapper.dtoFromMessage(messageRepository.findById(id).orElse(null));
    }

    public MessageDTO save(MessageDTO messageDto) {
        Message message = messageMapper.messageFromDto(messageDto);
        message.setTimestamp(LocalDateTime.now());
        messageRepository.save(message);
        return messageMapper.dtoFromMessage(message);
    }

    public MessageDTO update(String id, MessageDTO messageDto) {
        Message message = messageRepository.findById(id).orElse(null);
        messageMapper.updateMessageFromDto(messageDto, message);
        assert message != null;
        messageRepository.save(message);
        return messageMapper.dtoFromMessage(message);
    }

    public MessageDTO patch(String id, MessageDTO messageDto) {
        Message message = messageRepository.findById(id).orElse(null);
        messageMapper.patchMessageFromDto(messageDto, message);
        assert message != null;
        messageRepository.save(message);
        return messageMapper.dtoFromMessage(message);
    }

    public void delete(String id) {
        messageRepository.deleteById(id);
    }
}
