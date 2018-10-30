package com.david.shoppingcart.api.service.imp;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.david.shoppingcart.api.model.Address;
import com.david.shoppingcart.api.repository.AddressRepository;
import com.david.shoppingcart.api.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

	private AddressRepository addressRepository;

	@Autowired
	public AddressServiceImpl(AddressRepository addressRepository) {
		this.addressRepository = addressRepository;
	}

	@Override
	public Address save(Address entity) {
		Address address = this.addressRepository.save(entity);

		return address;
	}

	@Override
	public Address update(Long id, Address entity) {

		Address category = this.findById(id);

		BeanUtils.copyProperties(entity, category, "id", "customer");

		return this.addressRepository.save(category);
	}

	@Override
	public Address findById(Long id) {
		Optional<Address> address = this.addressRepository.findById(id);

		return address.orElseThrow(() -> new EmptyResultDataAccessException(1));
	}

	@Override
	public Iterable<Address> findAll() {
		return this.addressRepository.findAll();
	}

	@Override
	public void deleteById(Long id) {
		this.addressRepository.deleteById(id);
	}

}
