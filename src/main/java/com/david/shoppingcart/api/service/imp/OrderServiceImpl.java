package com.david.shoppingcart.api.service.imp;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.david.shoppingcart.api.model.Customer;
import com.david.shoppingcart.api.model.Order;
import com.david.shoppingcart.api.repository.OrderRepository;
import com.david.shoppingcart.api.service.CustomerService;
import com.david.shoppingcart.api.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	private OrderRepository orderRepository;
	private CustomerService customerService;

	public OrderServiceImpl(OrderRepository orderRepository, CustomerService customerService) {
		this.orderRepository = orderRepository;
		this.customerService = customerService;
	}

	@Override
	public Order save(Order entity) {

		Order item = this.orderRepository.save(entity);

		return item;
	}

	@Override
	public Order update(Long id, Order entity) {

		Order order = this.findById(id);

		BeanUtils.copyProperties(entity, order, "id", "customer", "itens", "address");

		return this.orderRepository.save(order);
	}

	@Override
	public Order findById(Long id) {
		Optional<Order> order = this.orderRepository.findById(id);

		return order.orElseThrow(() -> new EmptyResultDataAccessException(1));
	}

	@Override
	public Iterable<Order> findAll() {
		return this.orderRepository.findAll();
	}

	@Override
	public void deleteById(Long id) {
		this.orderRepository.deleteById(id);
	}

	@Override
	public Iterable<Order> findByCustomerId(Long id) {
		Customer customer = this.customerService.findById(id);

		return customer.getOrders();
	}
}
