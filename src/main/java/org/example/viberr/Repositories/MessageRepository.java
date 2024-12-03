package org.example.viberr.Repositories;

import org.example.viberr.Models.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MessageRepository extends MongoRepository<Message, String> {
}
