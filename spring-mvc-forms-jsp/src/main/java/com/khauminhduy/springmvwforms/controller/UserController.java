package com.khauminhduy.springmvwforms.controller;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.khauminhduy.springmvwforms.domain.User;

import jakarta.validation.Valid;

@Controller
public class UserController {
	
	private List<User> users = Arrays.asList(
		new User("ana@yahoo.com", "pass", "Ana", 20),
		new User("bob@yahoo.com", "pass", "Bob", 30),
		new User("john@yahoo.com", "pass", "John", 40),
		new User("mary@yahoo.com", "pass", "Mary", 30)
	);

	@GetMapping(value = "/userPage")
	public String getUserProfilePage() {
		return "user";
	}

	@PostMapping(value = "/user")
	@ResponseBody
	public ResponseEntity<Object> saveUser(@Valid User user, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			List<String> errors = result.getAllErrors().stream()
				.map(DefaultMessageSourceResolvable::getDefaultMessage)
				.collect(toList());

			return new ResponseEntity<>(errors, HttpStatus.OK);
		} else {
			if(users.stream().anyMatch(u -> user.getEmail().equals(u.getEmail()))) {
				return new ResponseEntity<>(Collections.singletonList("Email already exist"), HttpStatus.CONFLICT);
			} else {
				users.add(user);
				return new ResponseEntity<>(HttpStatus.CREATED);
			}
		}

	}

	@GetMapping(value = "/users")
	@ResponseBody
	public List<User> getUsers() {
		return users;
	}

}
