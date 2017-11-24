package com.wmak.restaurant.impl.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wmak.restaurant.impl.entity.DishEntity;
import com.wmak.restaurant.impl.entity.UserEntity;
import com.wmak.restaurant.impl.repos.DishDao;
import com.wmak.restaurant.impl.repos.OrderDao;
import com.wmak.restaurant.impl.repos.UserDao;

import io.swagger.model.Dish;
import io.swagger.model.User;

public class AdminService implements AdminServiceInterface {

	@Autowired
	private UserDao userDao;

	@Autowired
	private DishDao dishDao;

	@Autowired
	private OrderDao orderDao;

	@Override
	public void addNewUser(User user) {

	}

	@Override
	public void deleteUser(User user) {

		String id = user.getId();
		userDao.delete(id);
	}

	@Override
	public void modifyUser(User user, String newUsername) {

		String id = user.getId();
		userDao.updateUser(id, newUsername);
	}

	@Override
	public void addNewDishToMenu(Dish dish, String name, double price, String category) {

	}

	@Override
	public void deleteDishFromMenu(Dish dish) {

		String id = dish.getId();
		userDao.delete(id);
	}

	@Override
	public void modifyDish() {

	}

	@Override
	public DishEntity findDishByID(String id) {

	}

	@Override
	public UserEntity findUserByID(String id) {

	}

	@Override
	public List<User> getListOfUsers() {
		return userDao.findAll();
	}

	@Override
	public List<Dish> getListOfDishes() {
		return dishDao.findAll();
	}

	@Override
	public List getListOfDishesByCategory(String category) {

	}

}
