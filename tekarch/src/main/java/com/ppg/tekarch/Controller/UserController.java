package com.ppg.tekarch.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ppg.tekarch.Entity.*;
import com.ppg.tekarch.Service.*;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired(required=false)
	UserService userve;
	
	
	//Create or insert a user record
	@PostMapping("postUser")
	@CrossOrigin(origins = "http://localhost:3000")
	public UserEntity insertUser(@RequestBody UserEntity user) {
		 return userve.insertUser(user);
	}
	
	//Read all records
	@GetMapping("/displayAllUser")
	@CrossOrigin(origins = "http://localhost:3000")
	public List<UserEntity> getAllUser(){
		return userve.getAllUser();
	}
	
	
	//Update a record
	 @PutMapping("/putUser")
	 @CrossOrigin(origins = "http://localhost:3000")
	 public UserEntity putUser(@RequestParam int userID, @RequestBody UserEntity newUserDetails) throws Exception{
		 return userve.putUser(userID, newUserDetails);
	 }
	 
	//Delete a record
	 @DeleteMapping("/deleteUser/{userID}")
	 @CrossOrigin(origins = "http://localhost:3000")
	 public String deleteUser(@PathVariable int userID) {
		 return userve.deleteUser(userID);
	 }
	 
	 //Read user by username
	 @GetMapping("/userlogin")
	 @CrossOrigin(origins = "http://localhost:3000")
	 public Optional<UserEntity> findByUsername(@RequestParam String username) {
			 return userve.findByUsername(username);
		 
	 }

}
