package com.example.javacuisine.restaurant;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public List<Restaurant> getRestaurants() {
        return restaurantRepository.findAll();
    }

    public Optional<Restaurant> getRestaurantById(Long id) {
        return restaurantRepository.findById(id);
    }

    public void addNewRestaurant(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }

    public void removeRestaurant(Long id) {
        if (!restaurantRepository.existsById(id)) {
            throw new IllegalStateException("Restaurant with id of [" + id + "] does not exist.");
        }
        restaurantRepository.deleteById(id);
    }

    @Transactional
    public void updateRestaurant(Long id, String newName, double newLatitude, double newLongitude, String newAddress, String newContact) {
        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow();
        if (newName != null && !newName.isEmpty() && !Objects.equals(newName, restaurant.getName())) {
            restaurant.setName(newName);
        }
        if (newLatitude != restaurant.getLatitude()) {
            restaurant.setLatitude(newLatitude);
        }
        if (newLongitude != restaurant.getLongitude()) {
            restaurant.setLongitude(newLongitude);
        }
        if (newAddress != null && newAddress.isEmpty() && !Objects.equals(newAddress, restaurant.getAddress())) {
            restaurant.setAddress(newAddress);
        }
        if (newContact != null && newContact.isEmpty() && !Objects.equals(newContact, restaurant.getContact())) {
            restaurant.setContact(newContact);
        }
    }

}
