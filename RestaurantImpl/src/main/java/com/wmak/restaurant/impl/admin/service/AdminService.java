package com.wmak.restaurant.impl.admin.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wmak.restaurant.impl.converters.DishConverter;
import com.wmak.restaurant.impl.converters.OrderConverter;
import com.wmak.restaurant.impl.converters.UserConverter;
import com.wmak.restaurant.impl.entity.DishEntity;
import com.wmak.restaurant.impl.entity.OrderEntity;
import com.wmak.restaurant.impl.entity.UserEntity;

import com.wmak.restaurant.impl.repos.DishDao;
import com.wmak.restaurant.impl.repos.OrderDao;
import com.wmak.restaurant.impl.repos.UserDao;

import io.swagger.model.Dish;
import io.swagger.model.Order;
import io.swagger.model.User;

@Service
public class AdminService implements AdminServiceInterface {

	private UserDao userDao;
	private DishDao dishDao;
	private OrderDao orderDao;
	private DishConverter dishConverter;
	private OrderConverter orderConverter;
	private UserConverter userConverter;

	@Autowired
	public AdminService(UserDao userDao, DishDao dishDao, OrderDao orderDao, DishConverter dishConverter,
			OrderConverter orderConverter, UserConverter userConverter) {
		super();
		this.userDao = userDao;
		this.dishDao = dishDao;
		this.orderDao = orderDao;
		this.dishConverter = dishConverter;
		this.orderConverter = orderConverter;
		this.userConverter = userConverter;
	}

	@Override
	public User addNewUser(User user) {
		UserEntity userEntity = userConverter.modelToEntityConverter(user);
		userDao.save(userEntity);
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
		DishEntity dishEntity = dishConverter.modelToEntityConverter(dish);
		dishDao.save(dishEntity);
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
		DishEntity dishEntity = dishDao.findOne(id);
		return dishConverter.entityToModelConverter(dishEntity);
	}

	@Override
	public User findUserByID(String id) {
		UserEntity userEntity = userDao.findOne(id);
		return userConverter.entityToModelConverter(userEntity);
	}
	
	@Override
	public Order findOrderByID(String id) {
		OrderEntity orderEntity = orderDao.findOne(id);
		return orderConverter.entityToModelConverter(orderEntity);
	}

	@Override
	public void deleteOrder(String id) {
		orderDao.delete(id);

	}
	
	@Override
	public List<User> getListOfUsers() {
		 List<User> listOfUsers = userDao.findAll().stream()
														 .map(userEntity->userConverter.entityToModelConverter(userEntity))
														 .collect(Collectors.toList());
		 return listOfUsers;
	}

	@Override
	public List<Dish> getListOfDishes() {
		 List<Dish> listOfDishes = dishDao.findAll().stream()
				 								   .map(dishEntity->dishConverter.entityToModelConverter(dishEntity))
				 								   .collect(Collectors.toList());
		 return listOfDishes;
	}

	@Override
	public List<Order> getListOfOrders() {
		 List<Order> listOfOrders = orderDao.findAll().stream()
				   									  .map(orderEntity->orderConverter.entityToModelConverter(orderEntity))
				   									  .collect(Collectors.toList());
		 return listOfOrders;
	}

	@Override
	public List<Dish> getListOfDishesByCategory(String category) {
		List<DishEntity> list = dishDao.getDishByCategory(category);
		List<Dish> listOfDishes = list.stream()
				   					  .map(dishEntity->dishConverter.entityToModelConverter(dishEntity))
				   					  .collect(Collectors.toList());
		return listOfDishes;
	}

}
