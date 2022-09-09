package com.khauminhduy.repository;

import java.util.List;
import java.util.Optional;

public interface BookRepository {

	List<BookData> findAll();
	
	Optional<BookData> findById(String isbn);
	
	BookData add(BookData book);
	
}
