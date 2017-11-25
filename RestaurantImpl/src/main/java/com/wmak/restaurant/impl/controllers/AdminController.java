package com.wmak.restaurant.impl.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wmak.restaurant.impl.admin.service.AdminService;
import io.swagger.model.Dish;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@RequestMapping(value = "/dishes", method = RequestMethod.GET)
	public String userInbox(Model model) {
		List<Dish> dishes = adminService.getListOfDishes();
		model.addAttribute("dishes", dishes);
		return "admin/dishesList";
	}
}
