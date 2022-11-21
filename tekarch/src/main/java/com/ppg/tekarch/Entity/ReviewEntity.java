package com.ppg.tekarch.Entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_review")
public class ReviewEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reviewID;
	
	private String review;
	
	@OneToMany(cascade = CascadeType.MERGE)
	private Set<TbrEntity> book;
	
	@OneToMany(cascade = CascadeType.MERGE)
	private Set<UserEntity> user;
	
	public ReviewEntity(int reviewID, String review, Set<TbrEntity> book, Set<UserEntity> user) {
		super();
		this.reviewID = reviewID;
		this.review = review;
		this.book = book;
		this.user = user;
	}

	public Set<TbrEntity> getBook() {
		return book;
	}

	public void setBook(Set<TbrEntity> book) {
		this.book = book;
	}

	public Set<UserEntity> getUser() {
		return user;
	}

	public void setUser(Set<UserEntity> user) {
		this.user = user;
	}

	public void setReviewID(int reviewID) {
		this.reviewID = reviewID;
	}

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
	