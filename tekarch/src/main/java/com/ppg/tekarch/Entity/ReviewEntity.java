package com.ppg.tekarch.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_review")
public class ReviewEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reviewID;
	
	private String review;

	public ReviewEntity() {}
	
	public ReviewEntity(int reviewID, String review) {
		super();
		this.reviewID = reviewID;
		this.review = review;
	}

	public int getReviewID() {
		return reviewID;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	
}
	