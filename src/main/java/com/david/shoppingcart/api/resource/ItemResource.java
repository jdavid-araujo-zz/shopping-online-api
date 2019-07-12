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

import com.david.shoppingcart.api.model.Item;
import com.david.shoppingcart.api.service.ItemService;

@RestController
@RequestMapping(value = "/itens")
public class ItemResource {

	private ItemService itemService;

	@Autowired
	public ItemResource(ItemService itemService) {
		this.itemService = itemService;
	}

	@PostMapping
	private ResponseEntity<Item> save(@Valid @RequestBody Item entity) {

		Item item = this.itemService.save(entity);

		return ResponseEntity.status(HttpStatus.CREATED).body(item);
	}

	@PutMapping(value = "/{id}")
	private ResponseEntity<Item> update(@PathVariable Long id, @RequestBody Item entity) {

		Item item = this.itemService.update(id, entity);

		return ResponseEntity.ok(item);
	}

	@GetMapping(value = "/{id}")
	private ResponseEntity<Item> findById(@PathVariable Long id) {

		Item item = this.itemService.findById(id);

		return ResponseEntity.ok(item);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping(value = "/{id}")
	private void delete(@PathVariable Long id) {
		this.itemService.deleteById(id);
	}

}
