package com.david.shoppingcart.api.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_customer")
public class Customer implements Serializable {

	private static final long serialVersionUID = 2791839404396123882L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private Long id;

	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "first_name")
	private String firstName;

	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "last_name")
	private String lastName;

	@NotNull
	@Email
	@Column(name = "email")
	private String email;

	@NotNull
	@Pattern(regexp = "[\\d]{10}")
	@Column(name = "phone")
	private String phone;

	@OneToMany(mappedBy = "customer")
	private Set<Order> orders = new HashSet<>();

	@OneToMany(mappedBy = "customer")
	private Set<Address> address = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Set<Address> getAddress() {
		return address;
	}

	public void setAddress(Set<Address> address) {
		this.address = address;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
