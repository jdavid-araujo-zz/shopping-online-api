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

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	private ResponseEntity<Order> save(@Valid @RequestBody Order entity) {

		Order order = this.orderService.save(entity);

		return ResponseEntity.status(HttpStatus.CREATED).body(order);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	private ResponseEntity<Order> update(@PathVariable Long id, @RequestBody Order entity) {

		Order order = this.orderService.update(id, entity);

		return ResponseEntity.ok(order);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	private ResponseEntity<Order> findById(@PathVariable Long id) {

		Order order = this.orderService.findById(id);

		return ResponseEntity.ok(order);
	}

	@RequestMapping(value = "/customers/{id}", method = RequestMethod.GET)
	private ResponseEntity<Iterable<Order>> findByCustomer(@PathVariable("id") Long id) {

		Iterable<Order> order = this.orderService.findByCustomerId(id);

		return ResponseEntity.ok(order);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	private void delete(@PathVariable Long id) {
		this.orderService.deleteById(id);
	}
}
