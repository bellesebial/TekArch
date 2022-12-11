package com.ppg.tekarch.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ppg.tekarch.Entity.UserEntity;
import org.springframework.stereotype.Service;
import com.ppg.tekarch.Repository.UserRepository;

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
		public UserEntity putUser(int userID, UserEntity newUserDetails) throws Exception{
			
			UserEntity user = new UserEntity();
			
			try {
				//steps in updating
				//Step 1 - search the id number of the student
				user = urepo.findById(userID).get(); //findById() is a pre-defined method
				
				//Step 2- update the record
				user.setPassword(newUserDetails.getPassword());
				
				//Step 3 - save the information and return the value
				return urepo.save(user);
			} catch(NoSuchElementException nex) {
				throw new Exception ("User " +userID+ " does not exist!");
			}
		}
		
		//D- Delete student record
		public String deleteUser(int userID) {
			String msg;
			if(urepo.findById(userID) != null) {
				urepo.deleteById(userID);
				
				msg = "User " + userID + " is successfully deleted!";
			}
			else
				msg = "User: " + userID  + " is NOT found!";
			
			return msg;
		}
		
		//read user by username
		public Optional <UserEntity> findByUsername(String username) {
			if(urepo.findByUsername(username) !=null)
				return Optional.ofNullable(urepo.findByUsername(username));
			else
				return null;
		}

	

}
