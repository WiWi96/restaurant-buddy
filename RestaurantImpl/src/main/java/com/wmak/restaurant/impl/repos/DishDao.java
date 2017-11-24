package com.wmak.restaurant.impl.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.wmak.restaurant.impl.entity.DishEntity;

public interface DishDao extends JpaRepository<DishEntity, String>{

	@Modifying(clearAutomatically = true)
	@Query("UPDATE DishEntity d SET d.name = ?2 WHERE d.id = ?1")
	void updateDish(String id, String name);
}
