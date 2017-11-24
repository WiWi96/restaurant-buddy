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
@Table(name = "USERS")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM UserEntity u")
public class UserEntity {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	private String id;
	private String username;
	private String password;
	private String email;

	private List<OrderEntity> listOfOrders;

	public UserEntity() {
		this.listOfOrders = new LinkedList<>();
	}



	public UserEntity(String id, String username, String password, String email, List<OrderEntity> ordersOfUser) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.listOfOrders = ordersOfUser;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<OrderEntity> getOrdersOfUser() {
		return listOfOrders;
	}

	public void setOrdersOfUser(List<OrderEntity> ordersOfUser) {
		this.listOfOrders = ordersOfUser;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

}
