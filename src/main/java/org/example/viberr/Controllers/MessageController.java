package org.example.viberr.Controllers;

import lombok.RequiredArgsConstructor;
import org.example.viberr.Models.Message;
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
    public ResponseEntity<List<Message>> getAllMessages() {
        List<Message> messages = messageService.findAll();
        return ResponseEntity.ok(messages);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Message> getMessageById(@PathVariable String id) {
        Message message = messageService.findById(id);
        return ResponseEntity.ok(message);
    }

    @PostMapping
    public ResponseEntity<Message> addMessage(@RequestBody Message message) {
        Message savedMessage = messageService.save(message);
        return ResponseEntity.ok(savedMessage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Message> updateMessage(@PathVariable String id, @RequestBody Message messageDetails) {
        Message updatedMessage = messageService.update(id, messageDetails);
        return ResponseEntity.ok(updatedMessage);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Message> patchMessage(@PathVariable String id, @RequestBody Message messageDetails) {
        Message patchedMessage = messageService.patch(id, messageDetails);
        return ResponseEntity.ok(patchedMessage);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable String id) {
        messageService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
