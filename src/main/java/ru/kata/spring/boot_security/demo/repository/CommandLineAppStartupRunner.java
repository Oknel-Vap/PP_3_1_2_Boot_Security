package ru.kata.spring.boot_security.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.HashSet;
import java.util.Set;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

    private final UserRepository userRepository;
    @Autowired
    public CommandLineAppStartupRunner(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String...args) throws Exception {
        Role role = new Role("ADMIN");
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(role);
        User admin = new User();
        admin.setName("admin");
        admin.setLastName("adminov");
        admin.setUsername("admin");
        admin.setPassword("$2y$10$ly.FBpZv/EG6xi3/ewkZ6Ou3Yx3ARFzixXMv2LrHMJ4a9/yoPF9eO");//"admin" in Bcrypt
        admin.setRoles(adminRoles);
        userRepository.save(admin);
    }
}
