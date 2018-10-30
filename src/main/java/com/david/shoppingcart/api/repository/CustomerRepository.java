package com.david.shoppingcart.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.david.shoppingcart.api.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
