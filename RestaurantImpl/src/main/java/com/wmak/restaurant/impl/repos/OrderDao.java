package com.wmak.restaurant.impl.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wmak.restaurant.impl.entity.OrderEntity;

public interface OrderDao extends JpaRepository<OrderEntity, String> {

	// @Query("INSERT INTO UserOrdersTable (userID, SELECT DishEntity d FROM
	// DishesTable dT WHERE d.id=dishID and d.id=dT.id)")
	// void addNewDishToOrder(@Param("dishID") String dishID, @Param("userID")
	// String userID);

	@Modifying(clearAutomatically = true)
	@Query("UPDATE OrderEntity oe WHERE SET d.name = ?2 WHERE d.id = ?1")
	void updateDish(@Param("userID") String userID, String name);

}
