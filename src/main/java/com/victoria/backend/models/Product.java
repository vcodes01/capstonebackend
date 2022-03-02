package com.victoria.backend.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//NOTES 
//Java Persistence API is a collection of classes and methods to persistently store the vast amounts of data into a database which is provided by the Oracle Corporation.


@Entity 
@Table(name="products")

//generating getters and setters
public class Product {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	///GenerationType.IDENTITY indicates the persistence provider must assign keys for the entity using a database identity column
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProducts() {
		return product_name;
	}
	public void setProducts(String product) {
		this.product_name = product;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@Column
	private String product_name;
	@Column
	private String price;
}
