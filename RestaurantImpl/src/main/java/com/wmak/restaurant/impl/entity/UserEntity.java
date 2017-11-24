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
	private static String generalID;
	private String id;
	private String username;
	private String password;

	private List<OrderEntity> ordersOfUser;

	public UserEntity() {
		this.ordersOfUser = new LinkedList<>();
	}

	public UserEntity(String id, String username, String password) {
		super();
		this.id = generalID;
		// generalID++;
		this.username = username;
		this.password = password;
		this.ordersOfUser = new LinkedList<>();
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
		return ordersOfUser;
	}

	public void setOrdersOfUser(List<OrderEntity> ordersOfUser) {
		this.ordersOfUser = ordersOfUser;
	}

}
