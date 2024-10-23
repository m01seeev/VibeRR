package org.example.viberr.Models;

import jakarta.persistence.Id;
import lombok.Data;
import org.example.viberr.Enums.AttachmentType;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "attachments")
public class Attachment {
    @Id
    private String id;
    private AttachmentType fileType;
    private String fileUrl;
    private String messageId;
}
