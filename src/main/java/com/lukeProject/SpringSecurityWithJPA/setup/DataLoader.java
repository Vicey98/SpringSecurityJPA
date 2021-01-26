package com.lukeProject.SpringSecurityWithJPA.setup;

import java.util.Arrays;
import java.util.List;

import com.lukeProject.SpringSecurityWithJPA.model.User;
import com.lukeProject.SpringSecurityWithJPA.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class DataLoader implements CommandLineRunner {
    @Autowired
    UserRepository userRepo;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public void run(String... args) throws Exception {
        User admin1 = new User(1, "Luke Xu", "lukexu123@gmail.com", "qwerty", "ROLE_ADMIN", true);
        User admin2 = new User(2, "Sam Smith", "ss@gmail.com", "qwerty", "ROLE_ADMIN", false);
        bcryptEncoder = new BCryptPasswordEncoder();
        String code = bcryptEncoder.encode("pass").toString();
        User admin = new User(10, "admin", "admin@gmail.com", code, "ROLE_ADMIN", false);

        User user1 = new User(3, "Katrina Benett", "noice@gmail.com", "qwerty", "ROLE_USER", false);
        User user2 = new User(4, "Takeshi Kovac", "envoy@gmail.com", "Quell", "ROLE_USER", true);
        User user3 = new User(5, "Reileen Kawahara", "CUTIE@gmail.com", "Tak", "ROLE_USER", true);
        User user4 = new User(6, "Rick Deckard", "replicant@gmail.com", "Rachael", "ROLE_USER", true);
        User user5 = new User(7, "Joi", "sad@gmail.com", "The irony", "ROLE_USER", true);
        User user = new User(11, "user", "user@gmail.com", code, "ROLE_USER", true);

        List<User> adminList = Arrays.asList(admin,admin1, admin2);
        List<User> userList = Arrays.asList(user,user1, user2, user3, user4, user5);

        userRepo.saveAll(adminList);
        userRepo.saveAll(userList);
    }

}
