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
@Table(name = "ORDERS")
@NamedQuery(name = "Order.findAll", query = "SELECT o FROM OrderEntity o")
public class OrderEntity {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	private String id;
	private List<DishEntity> listOfDishes;

	public OrderEntity() {
		this.listOfDishes = new LinkedList<>();
	}

	public OrderEntity(String id, List<DishEntity> listOfDishes) {
		super();
		this.id = id;
		this.listOfDishes = listOfDishes;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<DishEntity> getListOfDishes() {
		return listOfDishes;
	}

	public void setListOfDishes(List<DishEntity> listOfDishes) {
		this.listOfDishes = listOfDishes;
	}

}
