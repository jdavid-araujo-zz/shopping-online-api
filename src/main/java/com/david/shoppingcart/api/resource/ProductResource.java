package com.david.shoppingcart.api.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	private ResponseEntity<Product> save(@Valid @RequestBody Product entity) {

		Product product = this.productService.save(entity);

		return ResponseEntity.status(HttpStatus.CREATED).body(product);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	private ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product entity) {

		Product product = this.productService.update(id, entity);

		return ResponseEntity.ok(product);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	private ResponseEntity<Product> findById(@PathVariable Long id) {

		Product product = this.productService.findById(id);

		return ResponseEntity.ok(product);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	private ResponseEntity<Iterable<Product>> findAll() {

		Iterable<Product> category = this.productService.findAll();

		return ResponseEntity.ok(category);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	private void delete(@PathVariable Long id) {
		this.productService.deleteById(id);
	}

}
