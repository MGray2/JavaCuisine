package com.example.javacuisine.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {
    @Bean("user")
    CommandLineRunner commandLineRunner3(UserRepository repository) {
        return args -> {
            User freddyfazbear = new User(
                    "Freddy Fazbear",
                    "biteof1987"
            );
            User joe = new User(
                    "Joe is hungry",
                    "sneakadootlebite"
            );
            User steve = new User(
                    "Steve",
                    "Minecraft"
            );

            repository.saveAll(List.of(freddyfazbear, joe, steve));

        };
    }
}
