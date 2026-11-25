package com.cascade.example.modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long product_id;

	private String product_name;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	public Product() {
	}

	public Product(String product_name) {
		this.product_name = product_name;
	}

	public Long getId() {
		return product_id;
	}

	public void setId(Long product_id) {
		this.product_id = product_id;
	}

	public String getName() {
		return product_name;
	}

	public void setName(String product_name) {
		this.product_name = product_name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
