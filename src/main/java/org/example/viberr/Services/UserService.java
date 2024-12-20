package org.example.viberr.Services;

import lombok.RequiredArgsConstructor;
import org.example.viberr.DTO.UserDTO;
import org.example.viberr.Mappers.UserMapper;
import org.example.viberr.Models.User;
import org.example.viberr.Repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public List<UserDTO> findAll() {
        return userMapper.dtoListFromUser(userRepository.findAll());
    }

    public UserDTO findById(String id) {
        return userMapper.dtoFromUser(userRepository.findById(id).orElse(null));
    }

    public UserDTO save(UserDTO userDto) {
        User user = userMapper.userFromDto(userDto);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userRepository.save(user);
        return userMapper.dtoFromUser(user);
    }

    public UserDTO update(String id, UserDTO userDto) {
        User user = userRepository.findById(id).orElse(null);
        userMapper.updateUserFromDto(userDto, user);
        assert user != null;
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userRepository.save(user);
        return userMapper.dtoFromUser(user);
    }

    public UserDTO patch(String id, UserDTO userDto) {
        User user = userRepository.findById(id).orElse(null);
        userMapper.patchUserFromDto(userDto, user);
        assert user != null;
        if (userDto.getPassword() != null) {
            user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        }
        userRepository.save(user);
        return userMapper.dtoFromUser(user);
    }

    public void delete(String id) {
        userRepository.deleteById(id);
    }
}
