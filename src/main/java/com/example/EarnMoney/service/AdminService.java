package com.example.EarnMoney.service;

import com.example.EarnMoney.model.User;
import com.example.EarnMoney.repository.UserRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public AdminService(UserRepository userRepository,@Lazy PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    public User createUser(User userRequest) {
        User user = new User();
        user.setUsername(userRequest.getUsername());
        user.setPassword(passwordEncoder.encode(userRequest.getPassword())); // Encrypt password
        user.setRoles(userRequest.getRoles()); // "USER" or "ADMIN"
        return userRepository.save(user);
    }

    public User updateUser(Long userId, User userRequest) {
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        existingUser.setUsername(userRequest.getUsername());
        if (userRequest.getPassword() != null) {
            existingUser.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        }
        existingUser.setRoles(userRequest.getRoles());
        return userRepository.save(existingUser);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
