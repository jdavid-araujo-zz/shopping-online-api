package com.david.shoppingcart.api.resource;

import org.springframework.http.ResponseEntity;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	private ResponseEntity<Category> save(@Valid @RequestBody Category entity) {

		Category category = this.categoryService.save(entity);

		return ResponseEntity.status(HttpStatus.CREATED).body(category);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	private ResponseEntity<Category> update(@PathVariable Long id, @RequestBody Category entity) {

		Category category = this.categoryService.update(id, entity);

		return ResponseEntity.ok(category);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	private ResponseEntity<Category> findById(@PathVariable Long id) {

		Category category = this.categoryService.findById(id);

		return ResponseEntity.ok(category);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	private ResponseEntity<Iterable<Category>> findAll() {

		Iterable<Category> category = this.categoryService.findAll();

		return ResponseEntity.ok(category);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	private void delete(@PathVariable Long id) {
		this.categoryService.deleteById(id);
	}
}
