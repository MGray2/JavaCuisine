package com.example.javacuisine.review;

import com.example.javacuisine.restaurant.Restaurant;
import com.example.javacuisine.user.User;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    private String comment;
    private Integer rating;
    private Date dateCreated;

    // Getters and Setters
}