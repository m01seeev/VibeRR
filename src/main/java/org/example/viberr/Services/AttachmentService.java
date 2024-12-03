package org.example.viberr.Services;

import lombok.RequiredArgsConstructor;
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

    public List<Attachment> findAll() {
        return attachmentRepository.findAll();
    }

    public Attachment findById(String id) {
        return attachmentRepository.findById(id).orElse(null);
    }

    public Attachment save(Attachment attachment) {
        return attachmentRepository.save(attachment);
    }

    public Attachment update(String id, Attachment attachmentDetails) {
        Attachment attachment = findById(id);
        attachmentMapper.updateAttachmentFromDto(attachmentDetails, attachment);
        attachment.setId(id);
        return attachmentRepository.save(attachment);
    }

    public Attachment patch(String id, Attachment attachmentDetails) {
        Attachment attachment = findById(id);
        attachmentMapper.patchAttachmentFromDto(attachmentDetails, attachment);
        return attachmentRepository.save(attachment);
    }

    public void delete(String id) {
        attachmentRepository.deleteById(id);
    }
}
