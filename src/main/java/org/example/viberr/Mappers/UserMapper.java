package org.example.viberr.Mappers;

import org.example.viberr.DTO.UserDTO;
import org.example.viberr.Enums.UserRole;
import org.example.viberr.Models.User;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
    @Mapping(target = "id", ignore = true)
    void updateUserFromDto(UserDTO userDto, @MappingTarget User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void patchUserFromDto(UserDTO userDto, @MappingTarget User user);

    UserDTO dtoFromUser(User user);

    User userFromDto(UserDTO userDto);

    List<UserDTO> dtoListFromUser(List<User> userList);

    List<User> userListFromDto(List<UserDTO> userDtoList);

    default String userRoleToString(UserRole role) {
        return role != null ? role.name() : null;
    }

    default UserRole stringToUserRole(String role) {
        return role != null ? UserRole.valueOf(role.toUpperCase()) : null;
    }
}
