package org.example.viberr.Mappers;

import org.example.viberr.Enums.UserRole;
import org.example.viberr.Models.User;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void patchUserFromDto(User userDetails, @MappingTarget User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
    void updateUserFromDto(User userDetails, @MappingTarget User user);

    default String userRoleToString(UserRole role) {
        return role != null ? role.name() : null;
    }

    default UserRole stringToUserRole(String role) {
        return role != null ? UserRole.valueOf(role.toUpperCase()) : null;
    }
}
