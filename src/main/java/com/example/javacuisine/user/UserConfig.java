package com.example.javacuisine.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository) {
        return args -> {
            User freddyfazbear = new User(
                    "Freddy Fazbear",
                    "biteof1987"
            );
            repository.saveAll(List.of(freddyfazbear));

        };
    }
}
