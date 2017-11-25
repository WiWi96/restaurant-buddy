package com.wmak.restaurant.impl.admin.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wmak.restaurant.impl.entity.Dish;
import com.wmak.restaurant.impl.entity.Order;
import com.wmak.restaurant.impl.entity.User;

import com.wmak.restaurant.impl.repos.DishDao;
import com.wmak.restaurant.impl.repos.OrderDao;
import com.wmak.restaurant.impl.repos.UserDao;


@Service
public class AdminService implements AdminServiceInterface {

	private UserDao userDao;
	private DishDao dishDao;
	private OrderDao orderDao;

	@Autowired
	public AdminService(UserDao userDao, DishDao dishDao, OrderDao orderDao) {
		super();
		this.userDao = userDao;
		this.dishDao = dishDao;
		this.orderDao = orderDao;
	}

	@Override
	public User addNewUser(User user) {
		userDao.save(user);
		return user;
	}

	@Override
	public void deleteUser(User user) {
		String id = user.getId();
		userDao.delete(id);
	}

	@Override
	public void modifyUser(User user) {
		userDao.updateUser(user.getId(), user.getPassword(), user.getEmail());
	}

	@Override
	public Dish addNewDishToMenu(Dish dish) {
		dishDao.save(dish);
		return dish;
	}

	@Override
	public void deleteDishFromMenu(Dish dish) {
		String id = dish.getId();
		userDao.delete(id);
	}

	@Override
	public void modifyDish(Dish dish) {
		dishDao.updateDish(dish.getId(), dish.getName(), dish.getCategory(), dish.getPrice());
	}

	@Override
	public Dish findDishByID(String id) {
		Dish dish = dishDao.findOne(id);
		return dish;
	}

	@Override
	public User findUserByID(String id) {
		User user = userDao.findOne(id);
		return user;
	}
	
	@Override
	public Order findOrderByID(String id) {
		Order order = orderDao.findOne(id);
		return order;
	}

	@Override
	public void deleteOrder(String id) {
		orderDao.delete(id);

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
	public List<Order> getListOfOrders() {
		 return orderDao.findAll();
	}

	@Override
	public List<Dish> getListOfDishesByCategory(String category) {
		return dishDao.getDishByCategory(category);
	}

}
