package org.example.viberr.Controllers;

import lombok.RequiredArgsConstructor;
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
    public ResponseEntity<List<Attachment>> getAllAttachments() {
        List<Attachment> attachments = attachmentService.findAll();
        return ResponseEntity.ok(attachments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Attachment> getAttachmentById(@PathVariable String id) {
        Attachment attachment = attachmentService.findById(id);
        return ResponseEntity.ok(attachment);
    }

    @PostMapping
    public ResponseEntity<Attachment> addAttachment(@RequestBody Attachment attachment) {
        Attachment savedAttachment = attachmentService.save(attachment);
        return ResponseEntity.ok(savedAttachment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Attachment> updateAttachment(@PathVariable String id, @RequestBody Attachment attachmentDetails) {
        Attachment updatedAttachment = attachmentService.update(id, attachmentDetails);
        return ResponseEntity.ok(updatedAttachment);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Attachment> patchAttachment(@PathVariable String id, @RequestBody Attachment attachmentDetails) {
        Attachment patchedAttachment = attachmentService.patch(id, attachmentDetails);
        return ResponseEntity.ok(patchedAttachment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttachment(@PathVariable String id) {
        attachmentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
