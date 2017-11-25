package com.wmak.restaurant.impl.repos;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.wmak.restaurant.impl.entity.Dish;

@Transactional
public interface DishDao extends JpaRepository<Dish, String> {

	@Modifying(clearAutomatically = true)
	@Query("UPDATE Dish d SET d.name = ?2, d.category = ?3, d.price = ?4 WHERE d.id = ?1")
	void updateDish(String id, String name, String category, double price);

	@Query("SELECT d FROM Dish d WHERE d.category = ?1")
	List<Dish> getDishByCategory(String category);
}
