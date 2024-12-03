package org.example.viberr.Repositories;

import org.example.viberr.Models.Chat.Chat;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChatRepository extends MongoRepository<Chat, String> {
}
