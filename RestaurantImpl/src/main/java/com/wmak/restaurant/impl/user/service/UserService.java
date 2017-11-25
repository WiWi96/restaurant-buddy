package com.wmak.restaurant.impl.user.service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.wmak.restaurant.impl.entity.Dish;
import com.wmak.restaurant.impl.entity.Order;
import com.wmak.restaurant.impl.entity.User;
import com.wmak.restaurant.impl.permisionchecker.PermissionCheckerInterface;
import com.wmak.restaurant.impl.repos.DishDao;
import com.wmak.restaurant.impl.repos.OrderDao;
import com.wmak.restaurant.impl.repos.UserDao;


public class UserService implements UserServiceInterface {
	private UserDao userDao;
	private DishDao dishDao;
	private OrderDao orderDao;
	private PermissionCheckerInterface permissionChecker;

	@Autowired
	public UserService(UserDao userDao, DishDao dishDao, OrderDao orderDao) {
		super();
		this.userDao = userDao;
		this.dishDao = dishDao;
		this.orderDao = orderDao;
	}

	@Override
	public Order addDishToOrder(String userId, String dishId, String orderId) {
		Order orderEntity = orderDao.findOne(orderId);
		try {
			if (permissionChecker.checker(userId, orderId)) {
				orderEntity.getListOfDishes().add(dishDao.findOne(dishId));
				return orderEntity;
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
		return dishDao.findOne(id);
	}

	@Override
	public Order getOrder(String userId, String orderId) {
		Order order = orderDao.findOne(orderId);
		try {
			if (permissionChecker.checker(userId, orderId)) {
				return order;
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
		User user = userDao.findOne(id);
//		List<Dish> dishes = new LinkedList<>();
//		for (Order order : user.getOrdersOfUser()) {
//			for (Dish dish : order.getListOfDishes()) {
//				dishes.add(dish);
//			}
//		}
		return null;
	}

	@Override
	public List<Order> allUserOrders(String id) {
		User user = userDao.findOne(id);
		return null;
	}

	@Override
	public Order makeNewOrder(String userId, Order order) {
		orderDao.save(order);
		User user = userDao.findOne(userId);
//		user.getOrdersOfUser().add(order);
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
