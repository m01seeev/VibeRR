package org.example.viberr.Services;

import lombok.RequiredArgsConstructor;
import org.example.viberr.Mappers.ProfileMapper;
import org.example.viberr.Models.Profile;
import org.example.viberr.Repositories.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfileService {
    private final ProfileRepository profileRepository;
    private final ProfileMapper profileMapper;

    public List<Profile> findAll() {
        return profileRepository.findAll();
    }

    public Profile findById(Long id) {
        return profileRepository.findById(id).orElse(null);
    }

    public Profile save(Profile profile) {
        return profileRepository.save(profile);
    }

    public Profile update(Long id, Profile profileDetails) {
        Profile profile = findById(id);
        profileMapper.updateProfileFromDto(profileDetails, profile);
        profile.setId(id);
        return profileRepository.save(profile);
    }

    public Profile patch(Long id, Profile profileDetails) {
        Profile profile = findById(id);
        profileMapper.patchProfileFromDto(profileDetails, profile);
        return profileRepository.save(profile);
    }

    public void delete(Long id) {
        profileRepository.deleteById(id);
    }
}
