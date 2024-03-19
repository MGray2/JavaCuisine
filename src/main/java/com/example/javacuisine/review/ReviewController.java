package com.example.javacuisine.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="api/v1/review")
public class ReviewController {
    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService){
        this.reviewService = reviewService;
    }

    @GetMapping
    public List<Review> getReviews(){
        return reviewService.getReviews();
    }

    @GetMapping(path = "{reviewId}")
    public Optional<Review> getReviewById(@PathVariable("reviewId") Long id){
        return reviewService.getReviewById(id);
    }

    @PostMapping
    public void createNewReview(@RequestBody Long userId, Long restaurantId, String comment, Integer rating){
        reviewService.createReview(userId, restaurantId, comment, rating);
    }

    @DeleteMapping(path = "{reviewId}")
    public void removeReview(@PathVariable("reviewId") Long id){
        reviewService.removeReview(id);
    }

    @PutMapping(path = "{reviewId}")
    public void updateReview(@PathVariable("reviewId") Long id,
                             @RequestParam(required = false) String comment,
                             @RequestParam(required = false) Integer rating,
                             @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateCreated) {
        reviewService.updateReview(id, comment, rating, dateCreated);
    }

}

