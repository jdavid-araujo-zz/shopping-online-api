package com.david.shoppingcart.api.resource;

import org.springframework.http.ResponseEntity;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.david.shoppingcart.api.model.Category;
import com.david.shoppingcart.api.service.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

	private CategoryService categoryService;

	@Autowired
	public CategoryResource(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@PostMapping
	private ResponseEntity<Category> save(@Valid @RequestBody Category entity) {

		Category category = this.categoryService.save(entity);

		return ResponseEntity.status(HttpStatus.CREATED).body(category);
	}

	@PutMapping(value = "/{id}")
	private ResponseEntity<Category> update(@PathVariable Long id, @RequestBody Category entity) {

		Category category = this.categoryService.update(id, entity);

		return ResponseEntity.ok(category);
	}

	@GetMapping(value = "/{id}")
	private ResponseEntity<Category> findById(@PathVariable Long id) {

		Category category = this.categoryService.findById(id);

		return ResponseEntity.ok(category);
	}

	@GetMapping
	private ResponseEntity<Iterable<Category>> findAll() {

		Iterable<Category> category = this.categoryService.findAll();

		return ResponseEntity.ok(category);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping(value = "/{id}")
	private void delete(@PathVariable Long id) {
		this.categoryService.deleteById(id);
	}
}
