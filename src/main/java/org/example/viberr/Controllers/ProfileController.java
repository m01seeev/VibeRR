package org.example.viberr.Controllers;

import lombok.RequiredArgsConstructor;
import org.example.viberr.DTO.ProfileDTO;
import org.example.viberr.Services.ProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/profiles")
@RequiredArgsConstructor
public class ProfileController {
    private final ProfileService profileService;

    @GetMapping
    public ResponseEntity<List<ProfileDTO>> getAllProfiles() {
        List<ProfileDTO> profiles = profileService.findAll();
        return ResponseEntity.ok(profiles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfileDTO> getProfileById(@PathVariable Long id) {
        ProfileDTO profile = profileService.findById(id);
        return ResponseEntity.ok(profile);
    }

    @PostMapping
    public ResponseEntity<ProfileDTO> addProfile(@RequestBody ProfileDTO profileDto) {
        ProfileDTO savedProfile = profileService.save(profileDto);
        return ResponseEntity.ok(savedProfile);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfileDTO> updateProfile(@PathVariable Long id, @RequestBody ProfileDTO profileDto) {
        ProfileDTO updatedProfile = profileService.update(id, profileDto);
        return ResponseEntity.ok(updatedProfile);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProfileDTO> patchProfile(@PathVariable Long id, @RequestBody ProfileDTO profileDto) {
        ProfileDTO patchedProfile = profileService.patch(id, profileDto);
        return ResponseEntity.ok(patchedProfile);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfile(@PathVariable Long id) {
        profileService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
