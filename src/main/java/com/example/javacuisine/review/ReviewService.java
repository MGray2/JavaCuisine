package com.example.javacuisine.review;

import com.example.javacuisine.restaurant.Restaurant;
import com.example.javacuisine.restaurant.RestaurantRepository;
import com.example.javacuisine.user.User;
import com.example.javacuisine.user.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository, UserRepository userRepository, RestaurantRepository restaurantRepository) {
        this.reviewRepository = reviewRepository;
        this.userRepository = userRepository;
        this.restaurantRepository = restaurantRepository;
    }


    public List<Review> getReviews() {
        return reviewRepository.findAll();
    }

    public Optional<Review> getReviewById(Long id) {
        return reviewRepository.findById(id);
    }

    public void addNewReview(Review review) {
        reviewRepository.save(review);
    }


    public void removeReview(Long id){
        if (!reviewRepository.existsById(id)){
            throw new IllegalStateException("Review with id of [" + id + "] does not exist.");
        }
        reviewRepository.deleteById(id);
    }

    @Transactional
    public void updateReview(Long id, String newComment, Integer newRating, LocalDate newDateCreated){
        Review review = reviewRepository.findById(id).orElseThrow();
        if (newComment != null && !newComment.isEmpty() && !Objects.equals(newComment, review.getComment())) {
            review.setComment(newComment);
        }

        if (newRating != null && !Objects.equals(newRating, review.getRating())) {
            review.setRating(newRating);
            review.getRestaurant().calculateOverallRating();
        }

        if (newDateCreated != null && !Objects.equals(newDateCreated, review.getDateCreated())) {
            Date dateCreated = Date.from(newDateCreated.atStartOfDay(ZoneId.systemDefault()).toInstant());
            review.setDateCreated(dateCreated);
        }
    }
    @Transactional
    public void createReview(Long userId, Long restaurantId, String comment, Integer rating) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));

        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new EntityNotFoundException("Restaurant not found with id: " + restaurantId));

        // Ensure that the restaurant is saved/persisted before proceeding
        if (restaurant.getRestaurant_id() == null) {
            restaurant = restaurantRepository.save(restaurant);
        }

        Review review = new Review();
        review.setUser(user);
        review.setRestaurant(restaurant);
        review.setComment(comment);
        review.setRating(rating);
        reviewRepository.save(review);

        restaurant.addToReviews(review);
        restaurant.calculateOverallRating();
    }


}
