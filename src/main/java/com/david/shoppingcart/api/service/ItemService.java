package com.david.shoppingcart.api.service;

import org.springframework.data.repository.NoRepositoryBean;

import com.david.shoppingcart.api.model.Item;

@NoRepositoryBean
public interface ItemService extends BaseService<Item> {

}
