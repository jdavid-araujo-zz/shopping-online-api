package com.david.shoppingcart.api.resource;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.david.shoppingcart.api.model.Customer;
import com.david.shoppingcart.api.service.CustomerService;

@RestController
@RequestMapping(value = "/customers")
public class CustomerResource {

	private CustomerService customerService;

	public CustomerResource(CustomerService customerService) {
		this.customerService = customerService;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	private ResponseEntity<Customer> save(@Valid @RequestBody Customer entity) {

		Customer customer = this.customerService.save(entity);

		return ResponseEntity.status(HttpStatus.CREATED).body(customer);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	private ResponseEntity<Customer> update(@PathVariable Long id, @RequestBody Customer entity) {

		Customer customer = this.customerService.update(id, entity);

		return ResponseEntity.ok(customer);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	private ResponseEntity<Customer> findById(@PathVariable Long id) {

		Customer customer = this.customerService.findById(id);

		return ResponseEntity.ok(customer);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	private ResponseEntity<Iterable<Customer>> findAll() {

		Iterable<Customer> customer = this.customerService.findAll();

		return ResponseEntity.ok(customer);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	private void delete(@PathVariable Long id) {
		this.customerService.deleteById(id);
	}

}
