package org.example.viberr.Repositories;

import org.example.viberr.Models.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MessageRepository extends MongoRepository<Message, String> {

}
