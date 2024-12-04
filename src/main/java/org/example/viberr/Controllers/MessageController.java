package org.example.viberr.Controllers;

import lombok.RequiredArgsConstructor;
import org.example.viberr.DTO.MessageDTO;
import org.example.viberr.Services.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/messages")
public class MessageController {
    private final MessageService messageService;

    @GetMapping
    public ResponseEntity<List<MessageDTO>> getAllMessages() {
        List<MessageDTO> messages = messageService.findAll();
        return ResponseEntity.ok(messages);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MessageDTO> getMessageById(@PathVariable String id) {
        MessageDTO message = messageService.findById(id);
        return ResponseEntity.ok(message);
    }

    @PostMapping
    public ResponseEntity<MessageDTO> addMessage(@RequestBody MessageDTO messageDto) {
        MessageDTO savedMessage = messageService.save(messageDto);
        return ResponseEntity.ok(savedMessage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MessageDTO> updateMessage(@PathVariable String id, @RequestBody MessageDTO messageDto) {
        MessageDTO updatedMessage = messageService.update(id, messageDto);
        return ResponseEntity.ok(updatedMessage);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MessageDTO> patchMessage(@PathVariable String id, @RequestBody MessageDTO messageDto) {
        MessageDTO patchedMessage = messageService.patch(id, messageDto);
        return ResponseEntity.ok(patchedMessage);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable String id) {
        messageService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
