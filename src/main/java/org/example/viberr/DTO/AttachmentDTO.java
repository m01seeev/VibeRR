package org.example.viberr.DTO;

import lombok.Data;
import org.example.viberr.Enums.AttachmentType;

@Data
public class AttachmentDTO {
    private String id;
    private AttachmentType fileType;
    private String fileRef;
    private String messageId;
}
