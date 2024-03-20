package com.example.javacuisine.review;


import com.example.javacuisine.restaurant.Restaurant;
import com.example.javacuisine.user.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;


import java.util.List;
@DependsOn({"restaurant", "user"})
@Configuration
public class ReviewConfig {
    @Bean
    CommandLineRunner commandLineRunner1(ReviewRepository repository){
        return args -> {
            Review mickeyDeesReview = new Review(
                    new User(
                            "Guy Fieri",
                            "flavortown"
                    ),
                    new Restaurant(
                            "Johnny's Pizza House",
                            32.438678646,
                    -90.1212272331031,
                    "670 US-51, Ridgeland, MS 39157",
                    "+16017907333"
                    ),
                    "Excellent and hot food! Will come back.",
                    8
            );
            repository.saveAll(List.of(mickeyDeesReview));
        };
    }
}
