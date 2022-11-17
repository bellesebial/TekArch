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
	
	//C - Create or insert a student record
	public ReviewEntity insertReview(ReviewEntity review) {
		return rvrepo.save(review);
	}
	
	//R - Read all records from tbl_student
	public List<ReviewEntity> getAllReview(){
		return rvrepo.findAll();
	}
	
	//U - Update a student record 
	public ReviewEntity putReview(int reviewID, ReviewEntity newReviewDetails) throws Exception{
		
		ReviewEntity review = new ReviewEntity();
		
		try {
			//Steps in updating
			//Step 1 - search the id number of the student
			review = rvrepo.findById(reviewID).get(); //findById() is a pre-defined method
			
			//Step 2 - update the record
			review.setReview(newReviewDetails.getReview());
			
			//Step 3 - save the information and return the value
			return rvrepo.save(review);

		} catch(NoSuchElementException nex) {
			throw new Exception("Review ID " +reviewID+ "does not exist!");
		}
	}
	
	//D - Delete student record
	public String deleteReview(int reviewID){
		String msg;
		if(rvrepo.findById(reviewID) != null) {	//Step 1 - find the record
			rvrepo.deleteById(reviewID);			//Step 2 - delete the record
			
			msg = "Review ID " +reviewID+ " is successfully deleted!";
		}
		else
			msg = "Review ID " +reviewID+ " is NOT found!";
		
		return msg;
	}
	
}
