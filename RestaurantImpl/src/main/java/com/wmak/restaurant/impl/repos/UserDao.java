package com.wmak.restaurant.impl.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.wmak.restaurant.impl.entity.DishEntity;
import com.wmak.restaurant.impl.entity.UserEntity;

@Transactional
public interface UserDao extends JpaRepository<UserEntity, String> {

	@Modifying(clearAutomatically = true)
	@Query("UPDATE OrderDao d SET d.name = ?2 WHERE d.id = ?1")
	void updateDish(String id, String name);

}
