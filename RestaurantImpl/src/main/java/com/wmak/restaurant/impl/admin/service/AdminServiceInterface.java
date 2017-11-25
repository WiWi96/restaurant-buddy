package com.wmak.restaurant.impl.admin.service;

import java.util.List;

import io.swagger.model.Dish;
import io.swagger.model.Order;
import io.swagger.model.User;

public interface AdminServiceInterface {

	User addNewUser(User user);

	User findUserByID(String id);

	void deleteUser(String id);

	void modifyUser(User user);

	Dish addNewDishToMenu(Dish dish);

	Dish findDishByID(String id);

	void deleteDishFromMenu(String id);

	void modifyDish(Dish dish);

	Order findOrderByID(String id);

	void deleteOrder(String id);

	List<User> getListOfUsers();

	List<Order> getListOfOrders();

	List<Dish> getListOfDishes();

	List<Dish> getListOfDishesByCategory(String category);
}
