package com.example.javacuisine.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping
@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserServcie userServcie) {this.user = userService; }

    @GetMapping
    public List<UserService> getUserService() {return userService.getUser(); }

    @GetMapping
    public Optional<User>getUserById(@PathVariable("userId") Long id) {
        return userService.getUserById(id);
    }
    @PostMapping
    public void createNewUser(@RequestBody User user) {
        userService.addNewUser(user);
    }
    @DeleteMapping
    public void  removeUser(@PathVariable("userId") Long id) {userService.removeUser(id); }

    @PutMapping
    public void updateUser(@PathVariable("userId") Long id,
                               @RequestParam(required = false) String username,
                               @RequestParam(required = false) String password) {
        userService.updateUser(id, username, password);
    }
}
