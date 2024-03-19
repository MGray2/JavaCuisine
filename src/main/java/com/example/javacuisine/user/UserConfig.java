package com.example.javacuisine.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunner3(UserRepository repository) {
        return args -> {
            User freddyFazbear = new User(

            );
            repository.saveAll(List.of(freddyFazbear));

        };
    }
}
