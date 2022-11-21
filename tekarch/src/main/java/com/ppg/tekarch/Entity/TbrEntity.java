package com.ppg.tekarch.Entity;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_book")
public class TbrEntity {
		
	//define data members
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String title;
	private String author;
	private String genre;
	private String synopsis;
	private Date published;
	
	@ManyToOne
	@JoinColumn(name="reviewID")
	ReviewEntity review;
	
	@ManyToOne
	@JoinColumn(name="username")
	UserEntity user;
	
	//define default constructor
	public TbrEntity() {
		
	}
	
	//generate constructor
	public TbrEntity(int id, String title, String author, String genre, String synopsis, Date published, ReviewEntity review, UserEntity user) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.synopsis = synopsis;
		this.published = published;
		this.review = review;
		this.user = user;
	}

	//generate setters and getters
	public int getId() {
		return id;
	}

//	public void setId(int id) {
//		this.id = id;
//	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public Date getPublished() {
		return published;
	}

	public void setPublished(Date published) {
		this.published = published;
	}
	
	public ReviewEntity getReview() {
		return review;
	}

	public void setReview(ReviewEntity review) {
		this.review = review;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}
	
	
}