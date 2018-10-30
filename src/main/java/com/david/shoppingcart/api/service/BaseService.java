package com.david.shoppingcart.api.service;

import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseService<T> {
	
	T save(T entity);
	
	T update(Long id, T entity);
	
	T findById(Long id);
	
	Iterable<T> findAll();
	
	void deleteById(Long id);

}
