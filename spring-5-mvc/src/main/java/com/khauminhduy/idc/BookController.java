package com.khauminhduy.idc;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController implements BookOperations {

	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public List<Book> getAll() {
		return bookRepository.getItems();
	}

	@Override
	public Optional<Book> getById(int id) {
		return bookRepository.getById(id);
	}

	@Override
	public void save(Book book, int id) {
		bookRepository.save(id, book);
	}

}
