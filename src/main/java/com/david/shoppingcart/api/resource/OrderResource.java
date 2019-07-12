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

import com.david.shoppingcart.api.model.Order;
import com.david.shoppingcart.api.service.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

	private OrderService orderService;

	@Autowired
	public OrderResource(OrderService orderService) {
		this.orderService = orderService;
	}

	@PostMapping
	private ResponseEntity<Order> save(@Valid @RequestBody Order entity) {

		Order order = this.orderService.save(entity);

		return ResponseEntity.status(HttpStatus.CREATED).body(order);
	}

	@PutMapping(value = "/{id}")
	private ResponseEntity<Order> update(@PathVariable Long id, @RequestBody Order entity) {

		Order order = this.orderService.update(id, entity);

		return ResponseEntity.ok(order);
	}

	@GetMapping(value = "/{id}")
	private ResponseEntity<Order> findById(@PathVariable Long id) {

		Order order = this.orderService.findById(id);

		return ResponseEntity.ok(order);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping(value = "/{id}")
	private void delete(@PathVariable Long id) {
		this.orderService.deleteById(id);
	}
}
