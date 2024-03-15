package com.example.javacuisine.restaurant;

import com.example.javacuisine.review.Review;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double latitude;
    private Double longitude;
    private Long overallRating;
    private String address;
    private String contact;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Review> reviews;

    public Restaurant(String name, Double latitude, Double longitude, Long overallRating, String address, String contact) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.overallRating = overallRating;
        this.address = address;
        this.contact = contact;
    }

}