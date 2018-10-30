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

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	private ResponseEntity<Address> save(@Valid @RequestBody Address entity) {

		Address address = this.addressService.save(entity);

		return ResponseEntity.status(HttpStatus.CREATED).body(address);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	private ResponseEntity<Address> update(@PathVariable Long id, @RequestBody Address entity) {

		Address address = this.addressService.update(id, entity);

		return ResponseEntity.ok(address);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	private ResponseEntity<Address> findById(@PathVariable Long id) {

		Address address = this.addressService.findById(id);

		return ResponseEntity.ok(address);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	private ResponseEntity<Iterable<Address>> findAll() {

		Iterable<Address> address = this.addressService.findAll();

		return ResponseEntity.ok(address);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	private void delete(@PathVariable Long id) {
		this.addressService.deleteById(id);
	}
}
