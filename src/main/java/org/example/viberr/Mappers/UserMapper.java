package org.example.viberr.Mappers;

import org.example.viberr.Enums.Role;
import org.example.viberr.Models.User;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUserFromDto(User userDetails, @MappingTarget User user);

    default Role stringToRole(String role) {
        return Role.valueOf(role);
    }

    default String roleToString(Role role) {
        return role.name();
    }
}
