package com.david.shoppingcart.api.service.imp;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.david.shoppingcart.api.model.Category;
import com.david.shoppingcart.api.repository.CategoryRepository;
import com.david.shoppingcart.api.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	private CategoryRepository categoryRepository;

	@Autowired
	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public Category save(Category entity) {
		Category category = this.categoryRepository.save(entity);

		return category;
	}

	@Override
	public Category update(Long id, Category entity) {

		Category category = this.findById(id);

		BeanUtils.copyProperties(entity, category, "id");

		return this.categoryRepository.save(category);
	}

	@Override
	public Category findById(Long id) {
		Optional<Category> category = this.categoryRepository.findById(id);

		return category.orElseThrow(() -> new EmptyResultDataAccessException(1));
	}

	@Override
	public Iterable<Category> findAll() {
		return this.categoryRepository.findAll();
	}

	@Override
	public void deleteById(Long id) {
		this.categoryRepository.deleteById(id);
	}

}
