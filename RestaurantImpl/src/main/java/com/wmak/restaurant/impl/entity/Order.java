package com.wmak.restaurant.impl.entity;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "ORDERS")
@NamedQuery(name = "Order.findAll", query = "SELECT o FROM Order o")
public class Order {

	@Id
	@Column(name = "orderId")
	private String id;
	@Column(name = "tableId")
	private String tableId;
	@Column(name = "userId")
	private String userId;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "Order_Dish", joinColumns = { @JoinColumn(name = "orderId") }, inverseJoinColumns = {
			@JoinColumn(name = "dishId") })
	private List<Dish> listOfDishes;

	public Order() {
		this.listOfDishes = new LinkedList<>();
	}

	public Order(String id, String tableId, List<Dish> listOfDishes) {
		this.id = id;
		this.tableId = tableId;
		this.listOfDishes = listOfDishes;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTableId() {
		return tableId;
	}

	public void setTableId(String tableId) {
		this.tableId = tableId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Dish> getListOfDishes() {
		return listOfDishes;
	}

	public void setListOfDishes(List<Dish> listOfDishes) {
		this.listOfDishes = listOfDishes;
	}

}
