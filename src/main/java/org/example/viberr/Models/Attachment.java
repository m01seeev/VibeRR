package org.example.viberr.Models;

import lombok.Data;
import org.example.viberr.Enums.AttachmentType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "attachments")
public class Attachment {
    @Id
    private String id;
    private AttachmentType fileType;
    private String fileRef;
    private String messageId;
}
