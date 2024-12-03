package org.example.viberr.Mappers;

import org.example.viberr.Enums.AttachmentType;
import org.example.viberr.Models.Attachment;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.context.annotation.Bean;

@Mapper(componentModel = "spring")
public interface AttachmentMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void patchAttachmentFromDto(Attachment attachmentDetails, @MappingTarget Attachment attachment);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
    void updateAttachmentFromDto(Attachment attachmentDetails, @MappingTarget Attachment attachment);

    default String attachmentTypeToString(AttachmentType attachmentType) {
        return attachmentType != null ? attachmentType.name() : null;
    }

    default AttachmentType stringToAttachmentType(String attachmentType) {
        return attachmentType != null ? AttachmentType.valueOf(attachmentType.toUpperCase()) : null;
    }
}
