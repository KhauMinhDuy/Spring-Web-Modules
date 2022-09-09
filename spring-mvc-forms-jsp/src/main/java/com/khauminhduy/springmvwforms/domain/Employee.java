package com.khauminhduy.springmvwforms.domain;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Employee {

	private long id;

	@NotNull
	@Size(min = 5)
	private String name;

	@NotNull
	@Size(min = 7)
	private String contactNumber;

}
