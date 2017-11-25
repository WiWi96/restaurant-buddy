package com.wmak.restaurant.impl.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wmak.restaurant.impl.entity.Dish;
import com.wmak.restaurant.impl.entity.Order;
import com.wmak.restaurant.impl.user.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserWebController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/addDishToOrder/{userId}{dishId}{orderId}", method = RequestMethod.POST)
	public String addDish(Model model) {
		model.addAttribute("dish", new Dish());
		return "user/addDish";
	}

	@RequestMapping(value = "/dish/{id}", method = RequestMethod.GET)
	public String getDishByID(@PathVariable String id, Model model) {
		model.addAttribute("dish", userService.getDish(id));
		return "user/dish";
	}

	@RequestMapping(value = "/order/{userId}{orderId}", method = RequestMethod.GET)
	public String getOrder(@PathVariable String userId, @PathVariable String orderId, Model model) {
		model.addAttribute("order", userService.getOrder(userId, orderId));
		return "user/order";
	}

	@RequestMapping(value = "/orders/{userId}", method = RequestMethod.GET)
	public String getOrders(@PathVariable String userId, Model model) {
		model.addAttribute("orders", userService.getListOfOrders(userId));
		return "user/orders";
	}

	@RequestMapping(value = "/order/{userId}{order}", method = RequestMethod.POST)
	public String makeOrder(@PathVariable String userId, @PathVariable Order order, Model model) {
		model.addAttribute("order", userService.makeNewOrder(userId, order));
		return "user/newOrder";
	}

}
