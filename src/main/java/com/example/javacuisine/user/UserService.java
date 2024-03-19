package com.example.javacuisine.user;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<User> getUsers() {return userRepository.findAll();}

    public void addNewUser(User user) {
        Optional<User> user1 = userRepository.findById(user.getId());
        if (user1.isPresent()) {
            throw new IllegalStateException("This username is already being used.");
        }
        userRepository.save(user);
    }

        public void deleteUser(Long userId) {
            boolean exists = userRepository.existsById(userId);
            if (!exists) {
                throw new IllegalStateException("This user with the Id [" + userId + "] does not exists in this database");
            }
            userRepository.deleteById(userId);
        }
        public void updateUser(Long userId, String username, String password ){
            User user = userRepository.findById(userId).orElseThrow(() -> new IllegalStateException(
                    "The Username with the userId" + userId + "cannot be found." ));
            if (username != null &&
                    username.length() > 0 &&
                    !Objects.equals(user.getUsername(), username)) {
                Optional<User> userOptional = userRepository.findById(userId);
                if (userOptional.isPresent()) {
                    throw new IllegalStateException("Sorry, but this username is already being used.");
                }
                user.setUsername(username);
        }
    }
            public Optional<User> oneUser(Long userId) {
                boolean exists = userRepository.existsById(userId);
                if (!exists) {
                    throw new IllegalStateException(
                            "Cannot find the user with the Id number: " + userId + ".");
                }
                return userRepository.findById(userId);
            }
    }


