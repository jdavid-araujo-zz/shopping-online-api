package com.david.shoppingcart.api.service.imp;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.david.shoppingcart.api.model.Item;
import com.david.shoppingcart.api.repository.ItemRepository;
import com.david.shoppingcart.api.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	private ItemRepository itemRepository;

	@Autowired
	public ItemServiceImpl(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	@Override
	public Item save(Item entity) {

		Item item = this.itemRepository.save(entity);

		return item;
	}

	@Override
	public Item update(Long id, Item entity) {

		Item item = this.findById(id);

		BeanUtils.copyProperties(entity, item, "id", "product");

		return this.itemRepository.save(item);
	}

	@Override
	public Item findById(Long id) {
		Optional<Item> item = this.itemRepository.findById(id);

		return item.orElseThrow(() -> new EmptyResultDataAccessException(1));
	}

	@Override
	public Iterable<Item> findAll() {
		return this.itemRepository.findAll();
	}

	@Override
	public void deleteById(Long id) {
		this.itemRepository.deleteById(id);
	}

}
