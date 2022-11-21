package com.ppg.tekarch.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ppg.tekarch.Entity.TbrEntity;
import com.ppg.tekarch.Repository.TbrRepository;


@Service
public class TbrService {	
	
	@Autowired
	TbrRepository bkrepo;
	
	//C - Create or insert a student record
	public TbrEntity insertBook(TbrEntity book) {
		return bkrepo.save(book);
	}
	
	//Read all record from the table named tbl_student
	public List<TbrEntity> getAllBook(){
		return bkrepo.findAll();
	}

	//U- Update a student record 
	public TbrEntity putBook(int id, TbrEntity newBookDetails) throws Exception{
		// TODO Auto-generated method stub
		TbrEntity book = new TbrEntity();
		
		try {
			//Steps in updating
			//Step 1 - search the id number of the student
			book = bkrepo.findById(id).get(); //findById() is a pre-defined method
			
			//Step 2 - update the record
			book.setTitle(newBookDetails.getTitle());
			book.setAuthor(newBookDetails.getAuthor());
			book.setGenre(newBookDetails.getGenre());
			book.setSynopsis(newBookDetails.getSynopsis());
			book.setPublished(newBookDetails.getPublished());
			
			//Step 3 - save the information and return the value
			return bkrepo.save(book);
			
		}catch (NoSuchElementException nex) {
			throw new Exception("Book ID" + id + "does not exist!");
		}
	}
	
	//D - Delete student record
	public String deleteBook(int id) {
		String msg;
		
		if(bkrepo.findById(id) != null) {	//Step 1 - find the record
			bkrepo.deleteById(id);			//Step 2 - delete the record
			
			msg = "Book ID " + id + " is successfully deleted!";
		}
		else
			msg = "Book ID " + id + " is NOT found!";
		return msg;
	}

}
