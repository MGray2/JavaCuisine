package com.example.javacuisine.restaurant;

import com.example.javacuisine.review.Review;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long restaurant_id;

    private String name;
    private Double latitude;
    private Double longitude;
    @Transient
    private Double overallRating;
    private String address;
    private String contact;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Review> reviews = new ArrayList<>();

    public Restaurant(String name, Double latitude, Double longitude,  String address, String contact) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
        this.contact = contact;
    }

    public void addToReviews(Review review) {
        reviews.add(review);
    }

    public void calculateOverallRating() {
        if (reviews.isEmpty()) {
            this.setOverallRating(0.0); // Set overall rating to 0 if there are no reviews
        } else {
            double totalRating = 0;
            for (Review review : reviews) {
                totalRating += review.getRating();
            }
            double overallRating = totalRating / reviews.size();
            this.setOverallRating(overallRating); // Update the overall rating of the restaurant
        }
    }

}