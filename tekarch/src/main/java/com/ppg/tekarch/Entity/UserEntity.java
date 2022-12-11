package com.ppg.tekarch.Entity;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_useracc")
public class UserEntity {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int userID;
	private String username;
	private String password;
	private String program;
	private int year;
	private String firstname;
	private String lastname;
	
	@ManyToOne
	@JoinColumn(name="reviewID")
	ReviewEntity review;
	
	@OneToMany(cascade = CascadeType.MERGE)
	private Set <TbrEntity> book;
	
	public UserEntity (){}

	public UserEntity(int userID, String username, String password, String program, int year, String firstname, String lastname, ReviewEntity review, Set <TbrEntity> book) {
		super();
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.program = program;
		this.year = year;
		this.firstname = firstname;
		this.lastname = lastname;
		this.review = review;
		this.book = book;
	}
	
	

	public int getUserID() {
		return userID;
	}

	//public void setUserID(int userId) {
	//	this.userId = userID;
	//}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	} 

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	} 
	
	public ReviewEntity getReview() {
		return review;
	}

	public void setReview(ReviewEntity review) {
		this.review = review;
	}

	public Set<TbrEntity> getBook() {
		return book;
	}

	public void setBook(Set<TbrEntity> book) {
		this.book = book;
	}
	
	
}

