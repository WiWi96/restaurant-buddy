package com.wmak.restaurant.impl.user.service;

import java.util.List;

import com.wmak.restaurant.impl.entity.Dish;
import com.wmak.restaurant.impl.entity.Order;


public interface UserServiceInterface {

	Order makeNewOrder(String userId, Order order);

	void deleteOrder(String userId, String orderId);

	Order addDishToOrder(String userId,String dishId, String orderId);

	Order getOrder(String userId, String orderId);

	Dish getDish(String id);

	List<Dish> allUserDishes(String id);
	
	List<Order> allUserOrders(String id);

}
