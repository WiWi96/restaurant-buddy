package com.wmak.restaurant.impl.user.service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.wmak.restaurant.impl.converters.DishConverter;
import com.wmak.restaurant.impl.converters.OrderConverter;
import com.wmak.restaurant.impl.entity.DishEntity;
import com.wmak.restaurant.impl.entity.OrderEntity;
import com.wmak.restaurant.impl.entity.UserEntity;
import com.wmak.restaurant.impl.permisionchecker.PermissionCheckerInterface;
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
	private PermissionCheckerInterface permissionChecker;

	@Autowired
	public UserService(UserDao userDao, DishDao dishDao, OrderDao orderDao, DishConverter dishConverter,
			OrderConverter orderConverter) {
		super();
		this.userDao = userDao;
		this.dishDao = dishDao;
		this.orderDao = orderDao;
		this.dishConverter = dishConverter;
		this.orderConverter = orderConverter;
	}

	@Override
	public Order addDishToOrder(String userId, String dishId, String orderId) {
		OrderEntity orderEntity = orderDao.findOne(orderId);
		try {
			if (permissionChecker.checker(userId, orderId)) {
				orderEntity.getListOfDishes().add(dishDao.findOne(dishId));
				return orderConverter.entityToModelConverter(orderEntity);
			} else {
				throw new Exception("Nie znaleziono zamówienia");
			}
		} catch (Exception e) {
		System.out.println(e.getMessage());
		return null;
		}

	}

	@Override
	public Dish getDish(String id) {
		DishEntity dishEntity = dishDao.findOne(id);
		return dishConverter.entityToModelConverter(dishEntity);
	}

	@Override
	public Order getOrder(String userId, String orderId) {
		OrderEntity orderEntity = orderDao.findOne(orderId);
		try {
			if (permissionChecker.checker(userId, orderId)) {
				return orderConverter.entityToModelConverter(orderEntity);
			} else {
				throw new Exception("Nie znaleziono zamówienia");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

	@Override
	public List<Dish> allUserDishes(String id) {
		UserEntity userEntity = userDao.findOne(id);
		List<Dish> dishes = new LinkedList<>();
		for (OrderEntity orderEntity : userEntity.getOrdersOfUser()) {
			for (DishEntity dishEntity : orderEntity.getListOfDishes()) {
				dishes.add(dishConverter.entityToModelConverter(dishEntity));
			}
		}
		return dishes;
	}

	@Override
	public List<Order> allUserOrders(String id) {
		UserEntity userEntity = userDao.findOne(id);

		return userEntity.getOrdersOfUser().stream()
				.map(orderEntity -> orderConverter.entityToModelConverter(orderEntity)).collect(Collectors.toList());
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
		try {
			if (permissionChecker.checker(userId, orderId)) {
				orderDao.delete(orderId);
			} else {
				throw new Exception("Nie znaleziono zamówienia");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
