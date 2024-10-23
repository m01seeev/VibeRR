package org.example.viberr.Mappers;

import org.example.viberr.Enums.AttachmentType;
import org.example.viberr.Models.Attachment;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AttachmentMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateAttachmentFromDto(Attachment attachmentDetails, @MappingTarget Attachment attachment);

    default String attachmentTypeToString(AttachmentType attachmentType) {
        return attachmentType != null ? attachmentType.name() : null;
    }

    default AttachmentType stringToAttachmentType(String attachmentType) {
        return attachmentType != null ? AttachmentType.valueOf(attachmentType.toUpperCase()) : null;
    }
}
