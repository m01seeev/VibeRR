package org.example.viberr.Mappers;

import org.example.viberr.DTO.ProfileDTO;
import org.example.viberr.Enums.ProfileStatus;
import org.example.viberr.Models.Profile;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProfileMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
    @Mapping(target = "id", ignore = true)
    void updateProfileFromDto(ProfileDTO profileDto, @MappingTarget Profile profile);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void patchProfileFromDto(ProfileDTO profileDto, @MappingTarget Profile profile);

    ProfileDTO dtoFromProfile(Profile profile);

    Profile profileFromDto(ProfileDTO profileDto);

    List<ProfileDTO> dtoListFromProfile(List<Profile> profileList);

    List<ProfileDTO> profileListFromDto(List<ProfileDTO> profileDtoList);

    default String profileStatusToString(ProfileStatus profileStatus) {
        return profileStatus != null ? profileStatus.toString() : null;
    }

    default ProfileStatus stringToProfileStatus(String profileStatus) {
        return profileStatus != null ? ProfileStatus.valueOf(profileStatus.toUpperCase()) : null;
    }
}
