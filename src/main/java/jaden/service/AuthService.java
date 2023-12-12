package jaden.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jaden.model.User;
import jaden.repository.UserRepository;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public boolean authenticate(String username, String password) {
        // Check against the database using UserRepository
        User user = userRepository.findByUsernameAndPassword(username, password);

        return user != null;
    }
}
