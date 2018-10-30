package com.david.shoppingcart.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.david.shoppingcart.api.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

}
