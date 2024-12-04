package org.example.viberr.Mappers;

import org.example.viberr.DTO.AttachmentDTO;
import org.example.viberr.Enums.AttachmentType;
import org.example.viberr.Models.Attachment;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AttachmentMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
    @Mapping(target = "id", ignore = true)
    void updateAttachmentFromDto(AttachmentDTO attachmentDto, @MappingTarget Attachment attachment);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void patchAttachmentFromDto(AttachmentDTO attachmentDto, @MappingTarget Attachment attachment);

    AttachmentDTO dtoFromAttachment(Attachment attachment);

    Attachment attachmentFromDto(AttachmentDTO attachmentDto);

    List<AttachmentDTO> dtoListFromAttachment(List<Attachment> attachmentList);

    List<Attachment> attachmentListFromDto(List<AttachmentDTO> attachmentDtoList);

    default String attachmentTypeToString(AttachmentType attachmentType) {
        return attachmentType != null ? attachmentType.name() : null;
    }

    default AttachmentType stringToAttachmentType(String attachmentType) {
        return attachmentType != null ? AttachmentType.valueOf(attachmentType.toUpperCase()) : null;
    }
}
