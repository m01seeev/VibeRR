package org.example.viberr.Models;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Data;
import org.example.viberr.Enums.AttachmentType;
import org.mapstruct.EnumMapping;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "attachments")
public class Attachment {
    @Id
    private String id;
    @Enumerated(EnumType.STRING)
    private AttachmentType fileType;
    private String fileRef;
    private String messageId;
}
