package com.david.shoppingcart.api.service;

import org.springframework.data.repository.NoRepositoryBean;

import com.david.shoppingcart.api.model.Customer;

@NoRepositoryBean
public interface CustomerService extends BaseService<Customer>{

}
