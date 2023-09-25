package com.example.token.service;

import com.example.token.entity.User;
import com.example.token.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }
    public List<User> getUsers(){
        return userRepository.findAll();
    }
    public User getUserByEmail(String email){
        return userRepository.findByEmail(email);
    }
    public void saveUser(User user){
user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
userRepository.save(user);
    }
}
