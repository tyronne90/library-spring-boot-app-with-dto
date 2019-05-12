package com.sgic.library.service;

import java.util.List;

import com.sgic.library.entity.Book;


public interface BookService {
	Book getBookById(String bookId);
	Book save(Book book);
	List<Book> getAllBooks();
	Book deleteBookById(String bookId);
	Book updateBook(Book book);
}
