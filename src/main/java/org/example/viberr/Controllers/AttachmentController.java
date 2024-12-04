package org.example.viberr.Controllers;

import lombok.RequiredArgsConstructor;
import org.example.viberr.DTO.AttachmentDTO;
import org.example.viberr.Models.Attachment;
import org.example.viberr.Services.AttachmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/attachments")
@RequiredArgsConstructor
public class AttachmentController {
    private final AttachmentService attachmentService;

    @GetMapping
    public ResponseEntity<List<AttachmentDTO>> getAllAttachments() {
        List<AttachmentDTO> attachments = attachmentService.findAll();
        return ResponseEntity.ok(attachments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AttachmentDTO> getAttachmentById(@PathVariable String id) {
        AttachmentDTO attachment = attachmentService.findById(id);
        return ResponseEntity.ok(attachment);
    }

    @PostMapping
    public ResponseEntity<AttachmentDTO> addAttachment(@RequestBody AttachmentDTO attachmentDto) {
        AttachmentDTO savedAttachment = attachmentService.save(attachmentDto);
        return ResponseEntity.ok(savedAttachment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AttachmentDTO> updateAttachment(@PathVariable String id, @RequestBody AttachmentDTO attachmentDto) {
        AttachmentDTO updatedAttachment = attachmentService.update(id, attachmentDto);
        return ResponseEntity.ok(updatedAttachment);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<AttachmentDTO> patchAttachment(@PathVariable String id, @RequestBody AttachmentDTO attachmentDto) {
        AttachmentDTO patchedAttachment = attachmentService.patch(id, attachmentDto);
        return ResponseEntity.ok(patchedAttachment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttachment(@PathVariable String id) {
        attachmentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
