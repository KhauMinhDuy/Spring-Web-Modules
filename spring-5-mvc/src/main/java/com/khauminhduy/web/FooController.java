package com.khauminhduy.web;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.khauminhduy.model.Foo;
import com.khauminhduy.persistence.FooRepository;

@RestController
public class FooController {

	@Autowired
	private FooRepository fooRepository;

	@GetMapping(value = "/foos/{id}")
	@Validated
	public Foo findById(@PathVariable @Min(0) final long id) {
		return fooRepository.findById(id).orElse(null);
	}

	@GetMapping(value = "/foos")
	public List<Foo> findAll() {
		return fooRepository.findAll();
	}

	@GetMapping(value = "/foos", params = { "page", "size" })
	@Validated
	public List<Foo> findPaginated(@RequestParam("page") @Min(0) final int page,
			@RequestParam("size") @Max(100) final int size) {
		return fooRepository.findAll(PageRequest.of(page, size)).getContent();
	}

//API - write

	@PutMapping("/foos/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Foo update(@PathVariable("id") final String id, @RequestBody final Foo foo) {
		return foo;
	}

	@PostMapping("/foos")
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody final Foo foo) {
		if (null == foo || null == foo.getName()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, " 'name' is required");
		}
		fooRepository.save(foo);
	}
}
