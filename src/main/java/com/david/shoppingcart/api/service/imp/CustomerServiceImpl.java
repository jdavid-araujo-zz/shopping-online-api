package com.david.shoppingcart.api.service.imp;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.david.shoppingcart.api.model.Customer;
import com.david.shoppingcart.api.repository.CustomerRepository;
import com.david.shoppingcart.api.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository customerRepository;

	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public Customer save(Customer entity) {
		Customer customer = this.customerRepository.save(entity);

		return customer;
	}

	@Override
	public Customer update(Long id, Customer entity) {

		Customer customer = this.findById(id);

		BeanUtils.copyProperties(entity, customer, "id", "orders", "adress");

		return this.customerRepository.save(customer);
	}

	@Override
	public Customer findById(Long id) {
		Optional<Customer> customer = this.customerRepository.findById(id);

		return customer.orElseThrow(() -> new EmptyResultDataAccessException(1));

	}

	@Override
	public Iterable<Customer> findAll() {
		return this.customerRepository.findAll();
	}

	@Override
	public void deleteById(Long id) {
		this.customerRepository.deleteById(id);
	}

}
