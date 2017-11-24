package com.wmak.restaurant.impl.repos;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public class IngredientDao {

	@Modifying(clearAutomatically = true)
	@Query("INSERT INTO OrderEntity oe WHERE SET d.name = ?2 WHERE d.id = ?1")
	void updateDish(@Param("userID") String userID, String name);

}
