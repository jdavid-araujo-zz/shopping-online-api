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

import com.david.shoppingcart.api.model.Customer;
import com.david.shoppingcart.api.model.Order;
import com.david.shoppingcart.api.service.CustomerService;
import com.david.shoppingcart.api.service.OrderService;

@RestController
@RequestMapping(value = "/customers")
public class CustomerResource {

	private CustomerService customerService;
	private OrderService orderService;

	@Autowired
	public CustomerResource(CustomerService customerService,
							OrderService orderService) {
		this.customerService = customerService;
		this.orderService = orderService;
	}

	@PostMapping
	private ResponseEntity<Customer> save(@Valid @RequestBody Customer entity) {

		Customer customer = this.customerService.save(entity);

		return ResponseEntity.status(HttpStatus.CREATED).body(customer);
	}

	@PutMapping(value = "/{id}")
	private ResponseEntity<Customer> update(@PathVariable Long id, @RequestBody Customer entity) {

		Customer customer = this.customerService.update(id, entity);

		return ResponseEntity.ok(customer);
	}

	@GetMapping(value = "/{id}")
	private ResponseEntity<Customer> findById(@PathVariable Long id) {

		Customer customer = this.customerService.findById(id);

		return ResponseEntity.ok(customer);
	}

	@GetMapping
	private ResponseEntity<Iterable<Customer>> findAll() {

		Iterable<Customer> customer = this.customerService.findAll();

		return ResponseEntity.ok(customer);
	}
	
	@GetMapping(value = "/customers/{id}/orders")
	private ResponseEntity<Iterable<Order>> findByCustomer(@PathVariable("id") Long id) {

		Iterable<Order> order = this.orderService.findByCustomerId(id);

		return ResponseEntity.ok(order);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping(value = "/{id}")
	private void delete(@PathVariable Long id) {
		this.customerService.deleteById(id);
	}

}
