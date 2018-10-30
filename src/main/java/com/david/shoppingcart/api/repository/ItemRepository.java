package com.david.shoppingcart.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.david.shoppingcart.api.model.Item;

public interface ItemRepository extends CrudRepository<Item, Long> {

}
