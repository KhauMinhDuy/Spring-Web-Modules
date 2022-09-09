package com.khauminhduy.exception;

import com.khauminhduy.dto.Book;

import lombok.Getter;

@Getter
public class DuplicateBookException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private final Book book;

	public DuplicateBookException(Book book) {
		this.book = book;
	}

}
