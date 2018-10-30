package com.david.shoppingcart.api.service;

import org.springframework.data.repository.NoRepositoryBean;

import com.david.shoppingcart.api.model.Order;

@NoRepositoryBean
public interface OrderService extends BaseService<Order> {

	Iterable<Order> findByCustomerId(Long id);
}
