package com.sgic.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.library.entity.Book;
import com.sgic.library.repository.BookRepository;

@Service
public class BookServiceImplement implements BookService{
	
	@Autowired
	BookRepository bookRepository;

	@Override
	public Book getBookById(String bookId) {
		return bookRepository.findBookByBookId(bookId);
	}

	@Override
	public Book save(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	@Override
	public Book deleteBookById(String bookId) {
		bookRepository.deleteById(bookId);
		return null;
	}

	@Override
	public Book updateBook(Book book) {
		String bookId = book.getBookId();
		boolean isExist = bookRepository.findBookByBookId(bookId) != null;
		if (isExist) {
			return bookRepository.save(book);
		}
		return null;
	}
	
}
