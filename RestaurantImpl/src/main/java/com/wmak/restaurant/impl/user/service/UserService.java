package com.wmak.restaurant.impl.user.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

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

public class UserService implements UserServiceInterface {
	private UserDao userDao;
	private DishDao dishDao;
	private OrderDao orderDao;
	private DishConverter dishConverter;
	private OrderConverter orderConverter;
	private UserConverter userConverter;

	@Autowired
	public UserService(UserDao userDao, DishDao dishDao, OrderDao orderDao, DishConverter dishConverter,
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
	public Order addDishToOrder(String dishId, String orderId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Dish getDish(String id) {
		DishEntity dishEntity = dishDao.findOne(id); 
		return dishConverter.entityToModelConverter(dishEntity);
	}

	@Override
	public Order getOrder(String userId,String orderId) {
		OrderEntity orderEntity = orderDao.findOne(orderId);
		UserEntity userEntity = userDao.findOne(userId);
		int positionOfOrder = userEntity.getOrdersOfUser().indexOf(orderEntity);
		return orderConverter.entityToModelConverter(orderEntity);

	}

	@Override
	public List<Dish> allUserDishes(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> allUserOrders(String id) {
		UserEntity userEntity = userDao.findOne(id);
		
		return userEntity.getOrdersOfUser().stream()
										   .map(orderEntity->orderConverter.entityToModelConverter(orderEntity))
										   .collect(Collectors.toList());
	}

	@Override
	public Order makeNewOrder(String userId, Order order) {
		OrderEntity orderEntity = orderConverter.modelToEntityConverter(order);
		orderDao.save(orderEntity);
		UserEntity userEntity = userDao.findOne(userId);
		userEntity.getOrdersOfUser().add(orderEntity);
		return order;
	}

	@Override
	public void deleteOrder(String userId, String orderId) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void modifyOrder(String userId, String orderId) {
		// TODO Auto-generated method stub
		
	}

}
