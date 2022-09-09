package com.khauminhduy.idc;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Book {

	private final int id;

	private final String title;

	private final String author;

	private final String genre;

	public Book() {
		this(-1, "", "", "");
	}

}
