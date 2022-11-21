package com.ppg.tekarch.Service;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;

import com.ppg.tekarch.Entity.UserEntity;
import com.ppg.tekarch.Entity.*;
import org.springframework.stereotype.Service;
import com.ppg.tekarch.Repository.*;

@Service
public class UserService {
	
	@Autowired(required=false)
	UserRepository urepo;
	
	
		//C-Create or insert a student record
		public UserEntity insertUser(UserEntity user) {
			return urepo.save(user);
		}
		
		//Read a record from the table named tbl_user
		public List<UserEntity> getAllUser(){
			return urepo.findAll();
		}
		
		
		//U - Update a student record
		public UserEntity putUser(String username, UserEntity newUserDetails) throws Exception{
			
			UserEntity user = new UserEntity();
			
			try {
				//steps in updating
				//Step 1 - search the id number of the student
				user = urepo.findById(username).get(); //findById() is a pre-defined method
				
				//Step 2- update the record
				user.setPassword(newUserDetails.getPassword());
				
				//Step 3 - save the information and return the value
				return urepo.save(user);
			} catch(NoSuchElementException nex) {
				throw new Exception ("User " +username+ " does not exist!");
			}
		}
		
		//D- Delete student record
		public String deleteUser(String username) {
			String msg;
			if(urepo.findById(username) != null) {
				urepo.deleteById(username);
				
				msg = "User " + username + " is successfully deleted!";
			}
			else
				msg = "User: " + username  + " is NOT found!";
			
			return msg;
		}

	

}
