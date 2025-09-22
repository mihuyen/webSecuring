package org.example.gssecuringweb.config;

import org.example.gssecuringweb.model.Role;
import org.example.gssecuringweb.model.User;
import org.example.gssecuringweb.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;

    public DataInitializer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) {
        // Create default admin user if not exists
        if (userRepository.findByUsername("admin").isEmpty()) {
            User adminUser = new User();
            adminUser.setUsername("admin");
            adminUser.setPassword("admin123");
            adminUser.setRole(Role.ADMIN);
            userRepository.save(adminUser);
        }
    }
}
