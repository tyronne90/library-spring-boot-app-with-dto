package com.sgic.library.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.library.dto.BookDTO;
import com.sgic.library.dtomapper.BookDTOMapper;

@RestController
public class BookController {
	@Autowired
	BookDTOMapper bookMapper;

	@PostMapping("/SaveBook")
	public HttpStatus saveBook(@Valid @RequestBody BookDTO bookDTO) {
		bookMapper.saveBook(bookDTO);
		return HttpStatus.CREATED;
	}

	@GetMapping("/GetAllBook")
	public List<BookDTO> getAllBook() {
		return bookMapper.getAllBook();
	}

	@GetMapping("/GetBookById/{bookId}")
	public ResponseEntity<BookDTO> getBookById(@PathVariable("bookId") String bookId) {
		return new ResponseEntity<BookDTO>(bookMapper.getBook(bookId), HttpStatus.OK);
	}

	@PutMapping("UpdateBook")
	public ResponseEntity<BookDTO> updateBook(@Valid @RequestBody BookDTO bookDTO) {
		bookMapper.updateBook(bookDTO);
		return new ResponseEntity<BookDTO>(bookDTO, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/DeleteBookById/{bookId}")
	public ResponseEntity<BookDTO> deleteBookById(@PathVariable("bookId") String bookId) {
		return new ResponseEntity<BookDTO>(bookMapper.deleteBook(bookId), HttpStatus.OK);
	}

}
