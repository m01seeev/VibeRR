package org.example.viberr.Controllers;

import lombok.RequiredArgsConstructor;
import org.example.viberr.Models.Chat.Chat;
import org.example.viberr.Services.ChatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/chats")
@RequiredArgsConstructor
public class ChatController {
    private final ChatService chatService;

    @GetMapping
    public ResponseEntity<List<Chat>> getChats() {
        List<Chat> chats = chatService.finAll();
        return ResponseEntity.ok(chats);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Chat> getChatById(@PathVariable String id) {
        Chat chat = chatService.findById(id);
        return ResponseEntity.ok(chat);
    }

    @PostMapping
    public ResponseEntity<Chat> addChat(@RequestBody Chat chat) {
        Chat savedChat = chatService.save(chat);
        return ResponseEntity.ok(savedChat);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Chat> updateChat(@PathVariable String id, @RequestBody Chat chatDetails) {
        Chat updatedChat = chatService.update(id, chatDetails);
        return ResponseEntity.ok(updatedChat);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Chat> patchChat(@PathVariable String id, @RequestBody Chat chatDetails) {
        Chat patchedChat = chatService.patch(id, chatDetails);
        return ResponseEntity.ok(patchedChat);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChat(@PathVariable String id) {
        chatService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
