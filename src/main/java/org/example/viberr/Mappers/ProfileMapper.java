package org.example.viberr.Mappers;

import org.example.viberr.Enums.ProfileStatus;
import org.example.viberr.Models.Profile;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProfileMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateProfileFromDto(Profile profileDetails, @MappingTarget Profile profile);

    default String profileStatusToString(ProfileStatus profileStatus) {
        return profileStatus != null ? profileStatus.toString() : null;
    }

    default ProfileStatus stringToProfileStatus(String profileStatus) {
        return profileStatus != null ? ProfileStatus.valueOf(profileStatus.toUpperCase()) : null;
    }
}
