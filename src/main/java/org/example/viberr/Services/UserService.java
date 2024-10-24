package org.example.viberr.Services;

import lombok.RequiredArgsConstructor;
import org.example.viberr.Mappers.UserMapper;
import org.example.viberr.Models.Subscription;
import org.example.viberr.Models.User;
import org.example.viberr.Repositories.SubscriptionRepository;
import org.example.viberr.Repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final SubscriptionRepository subscriptionRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User update(Long id, User userDetails) {
        User user = findById(id);
        user.setUsername(userDetails.getUsername());
        user.setEmail(userDetails.getEmail());
        user.setPhone(userDetails.getPhone());
        user.setPassword(passwordEncoder.encode(userDetails.getPassword()));
        user.setRole(userDetails.getRole());
        user.setProfile(userDetails.getProfile());
        return userRepository.save(user);
    }

    public User patch(Long id, User userDetails) {
        User user = findById(id);
        userMapper.updateUserFromDto(userDetails, user);
        return userRepository.save(user);
    }

    public void delete(Long id) {
        List<Subscription> subscriptions = subscriptionRepository.findBySubscribedFromId(id);
        subscriptions.addAll(subscriptionRepository.findBySubscribedToId(id));
        subscriptionRepository.deleteAll(subscriptions);
        userRepository.deleteById(id);
    }
}
