package com.wmak.restaurant.impl.repos;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UserDao {

	@Modifying(clearAutomatically = true)
	@Query("UPDATE OrderDao d SET d.name = ?2 WHERE d.id = ?1")
	void updateDish(String id, String name);

}
