package com.ppg.tekarch.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ppg.tekarch.Entity.ReviewEntity;
import com.ppg.tekarch.Service.ReviewService;

@RestController
@RequestMapping("/review")
public class ReviewController {

	@Autowired(required = false)
	ReviewService rvserv;
	
	//Create or insert a book review
	@PostMapping("/postReview")
	public ReviewEntity insertReview(@RequestBody ReviewEntity review) {
		return rvserv.insertReview(review);
	}
	
	//Read all review
	@GetMapping("/getAllReview")
	public List<ReviewEntity> getAllReview(){
		return rvserv.getAllReview();
	}
	
	//Update a review
	@PutMapping("/putReview")
	public ReviewEntity putReview(@RequestParam int reviewID, @RequestBody ReviewEntity newReviewDetails) throws Exception{
		return rvserv.putReview(reviewID, newReviewDetails);
	}
	
	//Delete a review
	@DeleteMapping("/deleteReview/{reviewID}")
	public String deleteReview(@PathVariable int reviewID) {
			return rvserv.deleteReview(reviewID);
	}
} 
