package com.victoria.backend.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
// an entity represents a table in a relational database, and each entity instance corresponds to a row in that table. The primary programming artifact of an entity is the entity class, although entities can use helper classes.
@Entity
@Table(name="cameras") //the name="___" needs to match the table name in your database
public class Camera {
//GenerationType.IDENTITY indicates that the persistence provider must assign primary keys for the entity using database identify column
//All annotations (@___) are located right above the objects or things you want to connect to
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	public int getId() {
		return id;
	}
//	public void setId(int id) {
//		this.id = id;
//	}
	public String getCamname() {
		return camname;
	}
	public void setCamname(String camname) {
		this.camname = camname;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageurl() {
		return imageurl;
	}
	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Column
	private String camname;
	@Column
	private String price;
	@Column
	private String description;
	@Column
	private String imageurl;
	@Column	
	private String category;
}
