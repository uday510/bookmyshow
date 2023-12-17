package com.lld.bookmyshow.services;
import com.lld.bookmyshow.models.User;
import com.lld.bookmyshow.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User signUp(String email, String password) {
        // validate if user already exists
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            throw new RuntimeException("User already exists");
        }
        User user = new User();
        user.setPassword(password);
        user.setBookings(new ArrayList<>());

        user = userRepository.save(user);

        return user;
    }
}
