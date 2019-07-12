package com.david.shoppingcart.api.resource;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.david.shoppingcart.api.model.Product;
import com.david.shoppingcart.api.service.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

	private ProductService productService;

	@Autowired
	public ProductResource(ProductService productService) {
		this.productService = productService;
	}

	@PostMapping
	private ResponseEntity<Product> save(@Valid @RequestBody Product entity) {

		Product product = this.productService.save(entity);

		return ResponseEntity.status(HttpStatus.CREATED).body(product);
	}

	@PutMapping(value = "/{id}")
	private ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product entity) {

		Product product = this.productService.update(id, entity);

		return ResponseEntity.ok(product);
	}

	@GetMapping(value = "/{id}")
	private ResponseEntity<Product> findById(@PathVariable Long id) {

		Product product = this.productService.findById(id);

		return ResponseEntity.ok(product);
	}

	@GetMapping
	private ResponseEntity<Iterable<Product>> findAll() {

		Iterable<Product> category = this.productService.findAll();

		return ResponseEntity.ok(category);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping(value = "/{id}")
	private void delete(@PathVariable Long id) {
		this.productService.deleteById(id);
	}

}
