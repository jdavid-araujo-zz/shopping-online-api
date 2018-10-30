package com.david.shoppingcart.api.service;

import org.springframework.data.repository.NoRepositoryBean;

import com.david.shoppingcart.api.model.Product;

@NoRepositoryBean
public interface ProductService extends BaseService<Product> {
	
}
