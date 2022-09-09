package com.khauminhduy.service;

import java.util.List;

import com.khauminhduy.dto.Book;

public interface BookService {

	List<Book> getBooks();
	
	Book addBook(Book book);
	
}
