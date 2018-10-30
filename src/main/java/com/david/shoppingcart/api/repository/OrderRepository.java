package com.david.shoppingcart.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.david.shoppingcart.api.model.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

}
