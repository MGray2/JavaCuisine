package com.example.javacuisine.restaurant;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestaurantConfig {

    @Bean
    CommandLineRunner commandLineRunner(RestaurantRepository repository) {
        return args -> {
            Restaurant mickyDees = new Restaurant(
                    "McDonalds",
                    34.36749577969106,
                    -89.55431611920868,
                    50L,
                    "1803 Jackson Ave W, Oxford, MS 38655",
                    "+16622366600"
            );
            repository.save(mickyDees);
        };
    }

}
