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

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	private ResponseEntity<Item> save(@Valid @RequestBody Item entity) {

		Item item = this.itemService.save(entity);

		return ResponseEntity.status(HttpStatus.CREATED).body(item);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	private ResponseEntity<Item> update(@PathVariable Long id, @RequestBody Item entity) {

		Item item = this.itemService.update(id, entity);

		return ResponseEntity.ok(item);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	private ResponseEntity<Item> findById(@PathVariable Long id) {

		Item item = this.itemService.findById(id);

		return ResponseEntity.ok(item);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	private void delete(@PathVariable Long id) {
		this.itemService.deleteById(id);
	}

}
