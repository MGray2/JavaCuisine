package com.example.javacuisine.restaurant;

import com.example.javacuisine.review.Review;
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
    private Long overallRating;
    private String address;
    private String contact;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Review> reviews = new ArrayList<>();

    public Restaurant(String name, Double latitude, Double longitude, Long overallRating, String address, String contact) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.overallRating = overallRating;
        this.address = address;
        this.contact = contact;
    }

    public double calculateOverallRating() {
        if (reviews.isEmpty()) {
            return 0; // Return 0 if there are no reviews
        }

        double totalRating = 0;
        for (Review review : reviews) {
            totalRating += review.getRating();
        }

        return totalRating / reviews.size();
    }

}