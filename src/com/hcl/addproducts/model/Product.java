package com.hcl.addproducts.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "pro_name")
	private String name;

	@Column(name = "pro_price")
	private double price;

	@Column(name = "pro_dept")
	private String department;

	public Product() {

	}

	public Product(String name, double price, String department) {
		this.name = name;
		this.price = price;
		this.department = department;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

}
