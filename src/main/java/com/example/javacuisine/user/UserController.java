package com.example.javacuisine.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping
@RestController
public class UserController {
    private final UserService userService;
    private UserRepository userRepository;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;}

    @GetMapping
    public List<User> getUserService() {return userService.getUsers(); }

    @GetMapping
    public User getUserById(@PathVariable("userId") Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalStateException("User not found"));
        return user;
    }
    @PostMapping
    public void createNewUser(@RequestBody User user) {
        userService.addNewUser(user);
    }
    @DeleteMapping
    public void  removeUser(@PathVariable("userId") Long id) {userService.deleteUser(id); }

    @PutMapping
    public void updateUser(@PathVariable("userId") Long id,
                               @RequestParam(required = false) String username,
                               @RequestParam(required = false) String password) {
        userService.updateUser(id, username, password);
    }

}
