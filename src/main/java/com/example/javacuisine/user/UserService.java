package com.example.javacuisine.user;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<User> getUsers() {return userRepository.findAll();}

    public void addNewUser(){}
}
