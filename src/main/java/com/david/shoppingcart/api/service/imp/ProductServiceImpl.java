package com.david.shoppingcart.api.service.imp;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.david.shoppingcart.api.model.Product;
import com.david.shoppingcart.api.repository.ProductRepository;
import com.david.shoppingcart.api.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductRepository productRepository;

	@Autowired
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public Product save(Product entity) {

		Product product = this.productRepository.save(entity);

		return product;
	}

	@Override
	public Product update(Long id, Product entity) {

		Product product = this.findById(id);

		BeanUtils.copyProperties(entity, product, "id", "category");

		return this.productRepository.save(product);
	}

	@Override
	public Product findById(Long id) {
		Optional<Product> product = this.productRepository.findById(id);

		return product.orElseThrow(() -> new EmptyResultDataAccessException(1));
	}

	@Override
	public Iterable<Product> findAll() {
		return this.productRepository.findAll();
	}

	@Override
	public void deleteById(Long id) {
		this.productRepository.deleteById(id);
	}

}
