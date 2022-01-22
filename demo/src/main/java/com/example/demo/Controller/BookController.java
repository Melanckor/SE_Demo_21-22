package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.datamodel.Book;
import com.example.demo.service.BookService;
@RequestMapping("/bookStore")
@RestController
public class BookController {

	public BookController() {
		// TODO Auto-generated constructor stub
	}
@Autowired
BookService bookSer;
@GetMapping
public ResponseEntity <List<Book>> getAllbooks(){
	List<Book>books = new ArrayList<Book>();
	books = bookSer.findBooks();
	return new ResponseEntity<>(books,HttpStatus.OK);
}
@GetMapping("/{id}")
public ResponseEntity<Book> getBookById(@PathVariable int id){
	return new ResponseEntity<>(bookSer.fetchBook(id).get(),HttpStatus.OK);
}
@PostMapping
public ResponseEntity<Book> addBookt(@RequestBody Book book){
	bookSer.addBook(book);
	return new ResponseEntity<>(book,HttpStatus.CREATED);
	}
@DeleteMapping("/{id}")
public ResponseEntity<Book> removeBookById(@PathVariable int id){
	Book book = bookSer.fetchBook(id).get();
	if(bookSer.deleteBook(id)) {
		return new ResponseEntity<>(book,HttpStatus.OK);
	}else {
		return new ResponseEntity<>(book,HttpStatus.BAD_REQUEST);
	  }
	}	
@GetMapping("/old")
public ResponseEntity<Book> getOldestBook(){
	int smallestYear=9999999;
	int IdOfSmall=1;
	List<Book>books = new ArrayList<Book>();
	books = bookSer.findBooks();
	for(Book bk:books) {
		if(bk.getYear() < smallestYear) {
			smallestYear= bk.getYear();
			IdOfSmall = bk.getId();
			} 
		
	}
	return new ResponseEntity<>(bookSer.fetchBook(IdOfSmall).get(),HttpStatus.OK);

}
@GetMapping("/new")
public ResponseEntity<Book> getNewestBook(){
	int newestYear=0;
	int IdOfBig=1;
	List<Book>books = new ArrayList<Book>();
	books = bookSer.findBooks();
	for(Book bk:books) {
		if(bk.getYear() > newestYear) {
			newestYear = bk.getYear();
			IdOfBig = bk.getId();
			} 
		
	}
	return new ResponseEntity<>(bookSer.fetchBook(IdOfBig).get(),HttpStatus.OK);

}

}
