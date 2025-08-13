package com.api.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.api.todo.error.UserAlreadyExistsException;
import com.api.todo.model.User;
import com.api.todo.repository.UserRepository;

@Service
public class AuthService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean userExists(String username) {
        return userRepository.existsByUsername(username);
    }

    public void registerUser(String name, String username, String password) {
        if (userExists(username)) {
            throw new UserAlreadyExistsException("Usuário já existe!");
        }
        
        User user = new User();
        user.setName(name);
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));

        userRepository.save(user);
    }

    


}
