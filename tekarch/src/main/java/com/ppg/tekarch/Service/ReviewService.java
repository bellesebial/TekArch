package com.ppg.tekarch.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ppg.tekarch.Entity.ReviewEntity;
import com.ppg.tekarch.Repository.ReviewRepository;

@Service
public class ReviewService {
	
	@Autowired(required = false)
	ReviewRepository rvrepo;
	
	//C - Create or insert a review
	public ReviewEntity insertReview(ReviewEntity review) {
		return rvrepo.save(review);
	}
	
	//R - Read all reviews from tbl_review
	public List<ReviewEntity> getAllReview(){
		return rvrepo.findAll();
	}
	
	//U - Update a review 
	public ReviewEntity putReview(int reviewID, ReviewEntity newReviewDetails) throws Exception{
		
		ReviewEntity review = new ReviewEntity();
		
		try {
			review = rvrepo.findById(reviewID).get(); 
			
			review.setReview(newReviewDetails.getReview());
			
			return rvrepo.save(review);

		} catch(NoSuchElementException nex) {
			throw new Exception("Review ID " +reviewID+ "does not exist!");
		}
	}
	
	//D - Delete review
	public String deleteReview(int reviewID){
		String msg;
		if(rvrepo.findById(reviewID) != null) {	
			rvrepo.deleteById(reviewID);		
			
			msg = "Review ID " +reviewID+ " is successfully deleted!";
		}
		else
			msg = "Review ID " +reviewID+ " is NOT found!";
		
		return msg;
	}
	
}
