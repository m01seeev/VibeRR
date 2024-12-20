package org.example.viberr.Services;

import lombok.RequiredArgsConstructor;
import org.example.viberr.DTO.ProfileDTO;
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

    public List<ProfileDTO> findAll() {
        return profileMapper.dtoListFromProfile(profileRepository.findAll());
    }

    public ProfileDTO findById(String id) {
        return profileMapper.dtoFromProfile(profileRepository.findById(id).orElse(null));
    }

    public ProfileDTO save(ProfileDTO profileDto) {
        Profile profile = profileMapper.profileFromDto(profileDto);
        profileRepository.save(profile);
        return profileMapper.dtoFromProfile(profile);
    }

    public ProfileDTO update(String id, ProfileDTO profileDto) {
        Profile profile = profileRepository.findById(id).orElse(null);
        profileMapper.updateProfileFromDto(profileDto, profile);
        assert profile != null;
        profileRepository.save(profile);
        return profileMapper.dtoFromProfile(profile);
    }

    public ProfileDTO patch(String id, ProfileDTO profileDto) {
        Profile profile = profileRepository.findById(id).orElse(null);
        profileMapper.patchProfileFromDto(profileDto, profile);
        assert profile != null;
        profileRepository.save(profile);
        return profileMapper.dtoFromProfile(profile);
    }

    public void delete(String id) {
        profileRepository.deleteById(id);
    }
}
