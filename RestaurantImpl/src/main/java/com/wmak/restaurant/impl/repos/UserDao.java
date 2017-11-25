package com.wmak.restaurant.impl.repos;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.wmak.restaurant.impl.entity.UserEntity;

@Transactional
public interface UserDao extends JpaRepository<UserEntity, String> {

	@Modifying(clearAutomatically = true)
	@Query("UPDATE OrderDao d SET d.password = ?2, d.email = ?3 WHERE d.id = ?1")
	void updateUser(String id, String password, String email);

}
