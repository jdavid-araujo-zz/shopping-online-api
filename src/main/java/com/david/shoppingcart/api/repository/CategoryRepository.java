package com.david.shoppingcart.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.david.shoppingcart.api.model.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

}
