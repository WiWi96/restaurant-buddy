package com.wmak.restaurant.impl.entity;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "DISHES")
@NamedQuery(name = "Dish.findAll", query = "SELECT d FROM DishEntity d")
public class DishEntity {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	private String id;
	private String name;
	private double price;
	private String category;

	private List<IngredientEntity> listOfIngredients;

	public DishEntity() {
		super();
	}

	public DishEntity(String id, String name, double price, String category) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.category = category;
		this.listOfIngredients = new LinkedList<>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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

	public List<IngredientEntity> getListOfIngredients() {
		return listOfIngredients;
	}

	public void setListOfIngredients(List<IngredientEntity> listOfIngredients) {
		this.listOfIngredients = listOfIngredients;
	}

}
