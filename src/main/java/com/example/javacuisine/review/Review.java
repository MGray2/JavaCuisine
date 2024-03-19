package com.example.javacuisine.review;

import com.example.javacuisine.restaurant.Restaurant;
import com.example.javacuisine.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
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

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dateCreated", nullable = false, updatable = false)
    @CreationTimestamp
    private Date dateCreated;

    public Review(String comment, Integer rating){
        this.comment = comment;
        this.rating = rating;
    }

    public Review(User user, Restaurant restaurant, String comment, Integer rating) {
        this.user = user;
        this.restaurant = restaurant;
        this.comment = comment;
        this.rating = rating;
    }


}
