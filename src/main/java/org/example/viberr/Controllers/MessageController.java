package org.example.viberr.Controllers;

import org.example.viberr.Models.Message;
import org.example.viberr.Services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/messages")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @GetMapping
    public List<Message> getAllMessages() {
        return messageService.getAllMessages();
    }

    @PostMapping
    public Message addMessage(@RequestBody Message message) {
        return messageService.createMessage(message);
    }
}
