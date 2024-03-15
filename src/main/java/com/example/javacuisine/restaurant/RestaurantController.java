package com.example.javacuisine.restaurant;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="api/v1/restaurant")
public class RestaurantController {

    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping
    public List<Restaurant> getRestaurants() {
        return restaurantService.getRestaurants();
    }

    @GetMapping(path="{restaurantId}")
    public Optional<Restaurant> getRestaurantById(@PathVariable("restaurantId") Long id) {
        return restaurantService.getRestaurantById(id);
    }

    @PostMapping
    public void createNewRestaurant(@RequestBody Restaurant restaurant) {
        restaurantService.addNewRestaurant(restaurant);
    }

    @DeleteMapping(path = "{restaurantId}")
    public void removeRestaurant(@PathVariable("restaurantId") Long id) {
        restaurantService.removeRestaurant(id);
    }

    @PutMapping(path = "{restaurantId}")
    public void updateRestaurant(@PathVariable("restaurantId") Long id,
                                 @RequestParam(required = false) String name,
    @RequestParam(required = false) double latitude,
    @RequestParam(required = false) double longitude,
    @RequestParam(required = false) String address,
    @RequestParam(required = false) String contact) {
        restaurantService.updateRestaurant(id, name, latitude, longitude, address, contact);
    }




}
