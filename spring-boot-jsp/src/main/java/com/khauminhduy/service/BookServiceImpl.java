package com.khauminhduy.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khauminhduy.dto.Book;
import com.khauminhduy.exception.DuplicateBookException;
import com.khauminhduy.repository.BookData;
import com.khauminhduy.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public List<Book> getBooks() {
		return bookRepository.findAll().stream().map(BookServiceImpl::convertBookData).collect(Collectors.toList());
	}

	@Override
	public Book addBook(Book book) {
		final Optional<BookData> existingBook = bookRepository.findById(book.getIsbn());
		if(existingBook.isPresent()) {
			throw new DuplicateBookException(book);
		}
		
		final BookData savedBook = bookRepository.add(convertBook(book));
		return convertBookData(savedBook);
	}

	private static Book convertBookData(BookData bookData) {
		return new Book(bookData.getIsbn(), bookData.getName(), bookData.getAuthor());
	}

	private static BookData convertBook(Book book) {
		return new BookData(book.getIsbn(), book.getName(), book.getAuthor());
	}

}
