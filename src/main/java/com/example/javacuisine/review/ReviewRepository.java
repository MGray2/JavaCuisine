package com.example.javacuisine.review;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>{
    @Query("SELECT r FROM Review r WHERE r.restaurant.restaurant_id = ?1")
    List<Review> findReviewByRestaurant(Long id);
}
