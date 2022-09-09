package com.khauminhduy.repository;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

@Repository
public class InMemoryBookRepository implements BookRepository {

	private final Map<String, BookData> storedBooks = new HashMap<>();

	@Override
	public List<BookData> findAll() {
		if (storedBooks.isEmpty()) {
			return Collections.emptyList();
		}
		return storedBooks.values().stream().collect(Collectors.toList());
	}

	@Override
	public Optional<BookData> findById(String isbn) {
		return Optional.ofNullable(storedBooks.get(isbn));
	}

	@Override
	public BookData add(BookData book) {
		storedBooks.put(book.getIsbn(), book);
		return book;
	}

}
