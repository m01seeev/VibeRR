package org.example.viberr.Controllers;

import lombok.RequiredArgsConstructor;
import org.example.viberr.Models.Profile;
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
    public ResponseEntity<List<Profile>> getAllProfiles() {
        List<Profile> profiles = profileService.findAll();
        return ResponseEntity.ok(profiles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profile> getProfileById(@PathVariable Long id) {
        Profile profile = profileService.findById(id);
        return ResponseEntity.ok(profile);
    }

    @PostMapping
    public ResponseEntity<Profile> addProfile(@RequestBody Profile profile) {
        Profile savedProfile = profileService.save(profile);
        return ResponseEntity.ok(savedProfile);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Profile> updateProfile(@PathVariable Long id, @RequestBody Profile profileDetails) {
        Profile updatedProfile = profileService.update(id, profileDetails);
        return ResponseEntity.ok(updatedProfile);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Profile> patchProfile(@PathVariable Long id, @RequestBody Profile profileDetails) {
        Profile patchedProfile = profileService.patch(id, profileDetails);
        return ResponseEntity.ok(patchedProfile);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Profile> deleteProfile(@PathVariable Long id) {
        profileService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
