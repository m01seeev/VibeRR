package org.example.viberr.Services;

import lombok.RequiredArgsConstructor;
import org.example.viberr.DTO.AttachmentDTO;
import org.example.viberr.Mappers.AttachmentMapper;
import org.example.viberr.Models.Attachment;
import org.example.viberr.Repositories.AttachmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AttachmentService {
    private final AttachmentRepository attachmentRepository;
    private final AttachmentMapper attachmentMapper;

    public List<AttachmentDTO> findAll() {
        return attachmentMapper.dtoListFromAttachment(attachmentRepository.findAll());
    }

    public AttachmentDTO findById(String id) {
        return attachmentMapper.dtoFromAttachment(attachmentRepository.findById(id).orElse(null));
    }

    public AttachmentDTO save(AttachmentDTO attachmentDto) {
        Attachment attachment = attachmentMapper.attachmentFromDto(attachmentDto);
        attachmentRepository.save(attachment);
        return attachmentMapper.dtoFromAttachment(attachment);
    }

    public AttachmentDTO update(String id, AttachmentDTO attachmentDto) {
        Attachment attachment = attachmentRepository.findById(id).orElse(null);
        attachmentMapper.updateAttachmentFromDto(attachmentDto, attachment);
        assert attachment != null;
        attachmentRepository.save(attachment);
        return attachmentMapper.dtoFromAttachment(attachment);
    }

    public AttachmentDTO patch(String id, AttachmentDTO attachmentDto) {
        Attachment attachment = attachmentRepository.findById(id).orElse(null);
        attachmentMapper.patchAttachmentFromDto(attachmentDto, attachment);
        assert attachment != null;
        attachmentRepository.save(attachment);
        return attachmentMapper.dtoFromAttachment(attachment);
    }

    public void delete(String id) {
        attachmentRepository.deleteById(id);
    }
}
