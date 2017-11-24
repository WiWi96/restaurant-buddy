package com.wmak.restaurant.impl.repos;

import org.springframework.data.jpa.repository.Query;

public class UserOrdersDao {

	@Query("SELECT DishEntity d SET d.name = ?2 WHERE d.id = ?1")
	void findDishById()
	
	
	
	
}
