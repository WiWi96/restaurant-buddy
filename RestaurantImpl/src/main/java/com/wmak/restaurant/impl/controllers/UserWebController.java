package com.wmak.restaurant.impl.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wmak.restaurant.impl.entity.Dish;
import com.wmak.restaurant.impl.user.service.UserService;


@Controller
@RequestMapping(value = "/user")
public class UserWebController {

//	@Autowired
//	private UserService userService;
//
//	@RequestMapping(value = "/addDishToOrder", method = RequestMethod.POST)
//	public String addDish(Model model) {
//		model.addAttribute("dish", new Dish());
//		return "user/addDish";
//	}

//	@RequestMapping(value = "/getDish/{id}", method = RequestMethod.GET)
//	public String getDish(@PathVariable String id, Model model) {
//		model.addAttribute("dishes", userService.findDishByID(id));
//		return "user/dish";
//	}
//
//	@RequestMapping(value = "/getOrder/{id}", method = RequestMethod.GET)
//	public String getOrder(@PathVariable String id, Model model) {
//		model.addAttribute("orders", userService.findOrderByID(id));
//		return "user/order";
//	}
//
//	@RequestMapping(value = "/getDishes", method = RequestMethod.GET)
//	public String getDishes(Model model) {
//		model.addAttribute("dishes", userService.getListOfDishes());
//		return "user/dishes";
//	}
//
//	@RequestMapping(value = "/getOrders", method = RequestMethod.GET)
//	public String getOrders(Model model) {
//		model.addAttribute("orders", userService.getListOfOrders());
//		return "user/orders";
//	}
//
//	@RequestMapping(value = "/makeNewOrder", method = RequestMethod.POST)
//	public String newOrder(Model model) {
//		model.addAttribute("order", new Order());
//		return "user/addOrder";
//	}
//
//	@RequestMapping(value = "/deleteOrder/{id}", method = RequestMethod.DELETE)
//	public String deleteOrder(@PathVariable String orderID, String userID) {
//		if (userService.findOrderByID(orderID) == null)
//			return "error404/orderNotFound";
//		userService.deleteOrder(userID, orderID);
//		return "redirect:/user/orders";
//	}
}
