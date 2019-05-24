package com.ecart.bbva.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecart.bbva.dto.BlogRequestDTO;
import com.ecart.bbva.dto.BlogResponseDTO;
import com.ecart.bbva.service.BlogService;

@RestController
@RequestMapping(value = "/blogs")
public class BlogController {

	@Autowired
	private BlogService<BlogRequestDTO, BlogResponseDTO> service;

	@GetMapping
	public ResponseEntity<List<BlogResponseDTO>> getAllBlog() {
		return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
	}

	@GetMapping(value = "/{blogId}")
	public ResponseEntity<BlogResponseDTO> getBlog(@PathVariable(required = true) String blogId) {
		BlogRequestDTO request = new BlogRequestDTO();
		request.setId(Long.valueOf(blogId));
		return new ResponseEntity<>(service.get(request), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Long> save(@RequestBody @Valid BlogRequestDTO blog) {
		return new ResponseEntity<>(service.save(blog).getId(), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<BlogResponseDTO> update(@RequestBody @Valid BlogRequestDTO blog) {
		return new ResponseEntity<>(service.update(blog), HttpStatus.OK);
	}

	@DeleteMapping(value = "/{blogId}")
	public ResponseEntity<Long> delete(@PathVariable(required = true) String blogId) {
		BlogRequestDTO request = new BlogRequestDTO();
		request.setId(Long.valueOf(blogId));
		return new ResponseEntity<>(service.update(request).getId(), HttpStatus.ACCEPTED);
	}

}
