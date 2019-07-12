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

import com.david.shoppingcart.api.model.Address;
import com.david.shoppingcart.api.service.AddressService;

@RestController
@RequestMapping(value = "/address")
public class AddressResource {

	private AddressService addressService;

	@Autowired
	public AddressResource(AddressService addressService) {
		this.addressService = addressService;
	}

	@PostMapping
	private ResponseEntity<Address> save(@Valid @RequestBody Address entity) {

		Address address = this.addressService.save(entity);

		return ResponseEntity.status(HttpStatus.CREATED).body(address);
	}

	@PutMapping(value = "/{id}")
	private ResponseEntity<Address> update(@PathVariable Long id, @RequestBody Address entity) {

		Address address = this.addressService.update(id, entity);

		return ResponseEntity.ok(address);
	}

	@GetMapping(value = "/{id}")
	private ResponseEntity<Address> findById(@PathVariable Long id) {

		Address address = this.addressService.findById(id);

		return ResponseEntity.ok(address);
	}

	@GetMapping
	private ResponseEntity<Iterable<Address>> findAll() {

		Iterable<Address> address = this.addressService.findAll();

		return ResponseEntity.ok(address);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping(value = "/{id}")
	private void delete(@PathVariable Long id) {
		this.addressService.deleteById(id);
	}
}
