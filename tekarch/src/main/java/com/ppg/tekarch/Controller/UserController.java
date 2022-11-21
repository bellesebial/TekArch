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

import com.ppg.tekarch.Entity.*;
import com.ppg.tekarch.Service.*;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired(required=false)
	UserService userve;
	
	
	//Create or insert a user record
	@PostMapping("postUser")
	public UserEntity insertUser(@RequestBody UserEntity user) {
		 return userve.insertUser(user);
	}
	
	//Read all records
	@GetMapping("/displayAllUser")
	public List<UserEntity> getAllUser(){
		return userve.getAllUser();
	}
	
	
	//Update a record
	 @PutMapping("/putUser")
	 public UserEntity putUser(@RequestParam String username, @RequestBody UserEntity newUserDetails) throws Exception{
		 return userve.putUser(username, newUserDetails);
	 }
	 
	//Delete a record
	 @DeleteMapping("/deleteUser/{username}")
	 public String deleteUser(@PathVariable String username) {
		 return userve.deleteUser(username);
	 }
	

}
