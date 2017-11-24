package com.wmak.restaurant.impl.admin.service;

import java.util.List;

public interface AdminServiceInterface {

	boolean addNewUser(String id, String username, String password);

	boolean deleteUser(String id);

	boolean modifyUser(String oldUsername, String newUsername);

	boolean addNewDishToMenu(String id, String name, double price, String category);

	boolean deleteDishFromMenu(String id);

	boolean modifyDish(String oldName, String newName, double newPrice);

	boolean modifyDish(String id, String newName);

	boolean modifyDish(String id, double price);

	boolean findDishByID(String id);

	boolean findUserByID(String id);

	List getListOfUsers();

	List getListOfDishes();

	List getListOfDishesByCategory(String category);
}
