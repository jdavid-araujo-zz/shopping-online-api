package com.david.shoppingcart.api.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.david.shoppingcart.api.util.enumeration.OrderStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {

	private static final long serialVersionUID = -239986669911720590L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private Long id;

	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private OrderStatus status;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_order_date")
	private Date orderDate;

	@Transient
	private BigDecimal amount;

	@NotNull
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@Valid
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Item> itens = new HashSet<>();

	@NotNull
	@OneToOne
	private Address address;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public BigDecimal getAmount() {
		amount = new BigDecimal(0);
		if ((this.getItens() != null) && (this.getItens().size() > 0)) {
			for (Item item : this.getItens()) {
				if (item.getProduct().getPrice() != null) {
					amount = amount.add(
							item.getProduct().getPrice().multiply(BigDecimal.valueOf(item.getQuantity().longValue())));
				}
			}
		}

		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Set<Item> getItens() {
		return itens;
	}

	public void setItens(Set<Item> itens) {
		this.itens = itens;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
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
		Order other = (Order) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
