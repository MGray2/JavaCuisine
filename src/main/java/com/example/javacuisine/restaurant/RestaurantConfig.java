package com.example.javacuisine.restaurant;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class RestaurantConfig {

    @Bean("restaurant")
    CommandLineRunner commandLineRunner(RestaurantRepository repository) {
        return args -> {
            Restaurant mickyDees = new Restaurant(
                    "McDonalds",
                    34.36749577969106,
                    -89.55431611920868,
                    "1803 Jackson Ave W, Oxford, MS 38655",
                    "+16622366600"
            );
            Restaurant hometownPizza = new Restaurant(
                    "Hometown Pizza Cafe",
                    34.15312442835395,
                    -89.63133030637401,
                    "407 N Main St, Water Valley, MS 38965",
                    "+16624739332"
            );
            Restaurant charritos = new Restaurant(
                    "El Charrito's",
                    34.14896375625693,
                    -89.6317733629896,
                    "119 N Main St, Water Valley, MS 38965",
                    "+16624734848"
            );
            Restaurant fnaf = new Restaurant(
                    "FREDDY FAZBEAR'S Pizza",
                    37.17736194791974,
                    -113.28126252839687,
                    "W 100 S, Hurricane, UT 84737",
                    "N/A"
            );
            repository.saveAll(List.of(mickyDees, hometownPizza, charritos, fnaf));
        };
    }

}
