package com.wmak.restaurant.impl.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wmak.restaurant.impl.admin.service.AdminService;
import com.wmak.restaurant.impl.entity.Dish;
import com.wmak.restaurant.impl.entity.User;


@Controller
@RequestMapping(value = "/admin")
public class AdminWebController {

	@Autowired
	private AdminService adminService;

	@RequestMapping(value = "/addDish", method = RequestMethod.POST)
	public String addDish(Model model) {
		model.addAttribute("dish", new Dish());
		return "admin/addDish";
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String addUser(Model model) {
		model.addAttribute("user", new User());
		return "admin/addUser";
	}

	@RequestMapping(value = "/updateUser/{id}", method = RequestMethod.PUT)
	public String updateUser(@PathVariable String id, Model model) {
		if (adminService.findUserByID(id) == null) {
			return "error404/userNotFound";
		}
		User user = adminService.findUserByID(id);
		model.addAttribute("user", user);
		return "admin/addUser";
	}

	@RequestMapping(value = "/updateDish/{id}", method = RequestMethod.PUT)
	public String updateDish(@PathVariable String id, Model model) {
		if (adminService.findDishByID(id) == null) {
			return "error404/dishNotFound";
		}
		Dish dish = adminService.findDishByID(id);
		model.addAttribute("dish", dish);
		return "admin/addDish";
	}

	@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.DELETE)
	public String deleteUser(@PathVariable String id) {
		if (adminService.findUserByID(id) == null) {
			return "error404/userNotFound";
		}
		adminService.deleteUser(id);
		return "redirect:/admin/users";
	}

	@RequestMapping(value = "/deleteDish/{id}", method = RequestMethod.DELETE)
	public String deleteDish(@PathVariable String id) {
		if (adminService.findDishByID(id) == null) {
			return "error404/dishNotFound";
		}
		adminService.deleteDishFromMenu(id);
		return "redirect:/admin/dishes";
	}

	@RequestMapping(value = "/deleteOrder/{id}", method = RequestMethod.DELETE)
	public String deleteOrder(@PathVariable String id) {
		if (adminService.findOrderByID(id) == null) {
			return "error404/orderNotFound";
		}
		adminService.deleteOrder(id);
		return "redirect:/admin/orders";
	}

	@RequestMapping(value = "/dish/{id}", method = RequestMethod.GET)
	public String getDishByID(@PathVariable String id, Model model) {
		model.addAttribute("dish", adminService.findUserByID(id));
		return "admin/dish";
	}

	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public String getUserByID(@PathVariable String id, Model model) {
		model.addAttribute("user", adminService.findUserByID(id));
		return "admin/user";
	}

//	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
//	public String getOrderByID(@PathVariable String id, Model model) {
//		model.addAttribute("order", adminService.findOrderByID(id));
//		return "admin/order";
//	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String getAllUsers(Model model) {
		model.addAttribute("users", adminService.getListOfUsers());
		return "admin/users";
	}

	@RequestMapping(value = "/orders", method = RequestMethod.GET)
	public String getAllOrders(Model model) {
		model.addAttribute("orders", adminService.getListOfOrders());
		return "admin/orders";
	}

	@RequestMapping(value = "/dishes", method = RequestMethod.GET)
	public String getAllDishes(Model model) {
		model.addAttribute("dishes", adminService.getListOfDishes());
		return "admin/dishes";
	}

	@RequestMapping(value = "/categorizedDishes", method = RequestMethod.GET)
	public String getCategorizedDises(Model model, String category) {
		model.addAttribute("categorizedDishes", adminService.getListOfDishesByCategory(category));
		return "admin/categorizedDishes";
	}

}
