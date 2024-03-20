package com.example.javacuisine;

import com.example.javacuisine.restaurant.Restaurant;
import com.example.javacuisine.restaurant.RestaurantRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final RestaurantRepository restaurantRepository;

    public HomeController(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Restaurant> restaurants = restaurantRepository.findAll();
        model.addAttribute("restaurants", restaurants);
        return "index";
    }
}
