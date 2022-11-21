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

import com.ppg.tekarch.Entity.TbrEntity;
import com.ppg.tekarch.Service.TbrService;

@RestController
@RequestMapping("/tbr")
public class TbrController {

	@Autowired
	TbrService bkserv;
	
//	//print Hello Student
//	@GetMapping("/print")
//	public String printHelloStudent() {
//		return "Hello, Student!";
//	}
	
	//Create or insert a student record
	@PostMapping("/postBook")
	public TbrEntity insertBook(@RequestBody TbrEntity book) {
		return bkserv.insertBook(book);
	}
	
	//Read all record
	@GetMapping("/getAllBook")
	public List<TbrEntity> getAllBook(){
		return bkserv.getAllBook();
	} 
	
//	//Read a record by Firstname
//	@GetMapping("/getByFirstname")
//	public TbrEntity findByFirstname(@RequestParam String firstname) {
//		return stserv.findByFirstname(firstname);
//	}
	
	//Update a record
	@PutMapping("/putBook")
	public TbrEntity putBook(@RequestParam int id, @RequestBody TbrEntity newBookDetails) throws Exception{
		return bkserv.putBook(id, newBookDetails);
	}  
	
	//Delete a record
	@DeleteMapping("/deleteBook/{id}")
	public String deleteBook (@PathVariable int id) {
		return bkserv.deleteBook(id);
	}
}