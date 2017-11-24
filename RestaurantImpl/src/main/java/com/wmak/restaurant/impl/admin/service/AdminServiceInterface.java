package com.wmak.restaurant.impl.admin.service;

import java.util.List;

import com.wmak.restaurant.impl.entity.DishEntity;
import com.wmak.restaurant.impl.entity.UserEntity;

import io.swagger.model.Dish;
import io.swagger.model.User;

public interface AdminServiceInterface {

	void addNewUser(User user);

	void deleteUser(User user);

	void modifyUser(User user, String newUsername);

	void addNewDishToMenu(Dish dish, String name, double price, String category);

	void deleteDishFromMenu(Dish dish);

	void modifyDish();

	DishEntity findDishByID(String id);

	UserEntity findUserByID(String id);

	List getListOfUsers();

	List getListOfDishes();

	List getListOfDishesByCategory(String category);
}
