package com.example.EarnMoney.config;

import com.example.EarnMoney.model.Role;
import com.example.EarnMoney.model.User;
import com.example.EarnMoney.repository.RoleRepository;
import com.example.EarnMoney.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        // Create roles
        Role adminRole = roleRepository.save(new Role("ROLE_ADMIN"));
        Role userRole = roleRepository.save(new Role("ROLE_USER"));

        // Save users
        User admin = userRepository.save(new User("admin", passwordEncoder.encode("admin123"), true, Set.of(adminRole)));
        User user = userRepository.save(new User("user", passwordEncoder.encode("user123"), true, Set.of(userRole)));

        userRepository.save(admin);
        userRepository.save(user);
    }
}
