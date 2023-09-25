package com.example.token.controller;

import com.example.token.entity.User;
import com.example.token.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private UserService userService;
    @PostMapping("/register")
    public ResponseEntity<HttpStatus> register(@RequestBody User user){
      userService.saveUser(user);
      return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id ){
        return userService.getUserById(id);
    }
    @GetMapping("/users")
    public List<User> getAllUser(){
      return   userService.getUsers();
    }

}
