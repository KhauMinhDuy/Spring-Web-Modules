package com.khauminhduy.springmvwforms.domain;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	@NotNull
	@Email
	private String email;

	@NotNull
	@Size(min = 4, max = 15)
	private String password;

	@NotBlank
	private String name;

	@Min(18)
	@Digits(integer = 2, fraction = 0)
	private int age;
}
