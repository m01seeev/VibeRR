package org.example.viberr.Repositories;

import org.example.viberr.Models.Attachment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AttachmentRepository extends MongoRepository<Attachment, String> {
}
