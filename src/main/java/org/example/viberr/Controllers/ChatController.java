package org.example.viberr.Controllers;

import lombok.RequiredArgsConstructor;
import org.example.viberr.DTO.Chat.ChatDTO;
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
    public ResponseEntity<List<ChatDTO>> getAllChats() {
        List<ChatDTO> chats = chatService.findAll();
        return ResponseEntity.ok(chats);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChatDTO> getChatById(@PathVariable String id) {
        ChatDTO chat = chatService.findById(id);
        return ResponseEntity.ok(chat);
    }

    @PostMapping
    public ResponseEntity<ChatDTO> addChat(@RequestBody ChatDTO chatDto) {
        ChatDTO savedChat = chatService.save(chatDto);
        return ResponseEntity.ok(savedChat);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChatDTO> updateChat(@PathVariable String id, @RequestBody ChatDTO chatDto) {
        ChatDTO updatedChat = chatService.update(id, chatDto);
        return ResponseEntity.ok(updatedChat);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ChatDTO> patchChat(@PathVariable String id, @RequestBody ChatDTO chatDto) {
        ChatDTO patchedChat = chatService.patch(id, chatDto);
        return ResponseEntity.ok(patchedChat);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChat(@PathVariable String id) {
        chatService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
