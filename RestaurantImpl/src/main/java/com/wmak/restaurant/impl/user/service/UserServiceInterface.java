package com.wmak.restaurant.impl.user.service;

import java.util.List;
import io.swagger.model.Dish;
import io.swagger.model.Order;

public interface UserServiceInterface {

	Order makeNewOrder(String userId, Order order);

	void deleteOrder(String userId, String orderId);

	Order addDishToOrder(String dishId, String orderId);

	Order getOrder(String userId, String orderId);
	
	void modifyOrder(String userId, String orderId);

	Dish getDish(String id);

	List<Dish> allUserDishes(String id);
	
	List<Order> allUserOrders(String id);

}
