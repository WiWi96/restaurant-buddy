package com.wmak.restaurant.impl;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.wmak.restaurant.impl.admin.service.AdminService;
import com.wmak.restaurant.impl.entity.DishEntity;
import com.wmak.restaurant.impl.entity.OrderEntity;
import com.wmak.restaurant.impl.entity.UserEntity;
import com.wmak.restaurant.impl.repos.DishDao;
import com.wmak.restaurant.impl.repos.OrderDao;
import com.wmak.restaurant.impl.repos.UserDao;

import io.swagger.model.Dish;
import io.swagger.model.Order;
import io.swagger.model.User;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class AdminServiceTest {

	@Autowired
	private UserDao userDao;
	private DishDao dishDao;
	private OrderDao orderDao;
	private AdminService adminService;

	@Test
	public void addUser() {
		LinkedList<Order> list = new LinkedList<>();
		User user = new User("1", "login", "haslo", "aa@gmail.com", list);
		adminService.addNewUser(user);
		assertFalse(userDao.findAll().isEmpty());
	}

	@Test
	public void addDish() {
		Dish dish = new Dish("1", "obiad", "abc", 11.11);
		adminService.addNewDishToMenu(dish);
		assertFalse(dishDao.findAll().isEmpty());
	}

	@Test
	public void deleteUser() {

		LinkedList<OrderEntity> list = new LinkedList<>();
		UserEntity userEntity = new UserEntity("1", "login", "haslo", "aa@gmail.com", list);
		LinkedList<Order> list2 = new LinkedList<>();
		String id = userEntity.getId();
		// tutaj troche na okolo, nie wiem czy moze tak byc
		// nie mozna zrobic save na obiekcie Dish
		// robie save na DishEntity i pozniej tworze Dish o tym samym id i sprawdzam czy
		// usuwa
		User user = new User(id, "login", "haslo", "aa@gmail.com", list2);
		userDao.save(userEntity);
		adminService.deleteUser(user);
		assertTrue(userDao.findAll().isEmpty());

	}

	@Test
	public void deleteDish() {
		DishEntity dishEntity = new DishEntity("1", "obiad", 11.11, "abc");
		String id = dishEntity.getId();

		// tutaj troche na okolo, nie wiem czy moze tak byc
		// nie mozna zrobic save na obiekcie Dish
		// robie save na DishEntity i pozniej tworze Dish o tym samym id i sprawdzam czy
		// usuwa
		Dish dish = new Dish(id, "obiad", "abc", 11.11);
		dishDao.save(dishEntity);
		adminService.deleteDishFromMenu(dish);
		assertTrue(dishDao.findAll().isEmpty());

	}

	@Test
	public void updateUser() throws Exception {
		LinkedList<OrderEntity> list = new LinkedList<>();
		UserEntity userEntity = new UserEntity("1", "login", "haslo", "aa@gmail.com", list);
		userDao.save(userEntity);
		LinkedList<Order> list2 = new LinkedList<>();
		User user = new User("8", "login", "haslo", "aa@gmail.com", list2);
		user.setId(userEntity.getId());
		adminService.modifyUser(user);
	}

	@Test
	public void updateDish() {
		DishEntity dishEntity = new DishEntity("1", "obiad", 11.11, "abc");
		dishDao.save(dishEntity);
		Dish dish = new Dish("3", "aa", "bb", 12.12);
		dish.setId(dishEntity.getId());
		adminService.modifyDish(dish);
	}

	@Test
	public void findUser() {
		LinkedList<OrderEntity> list = new LinkedList<>();
		UserEntity userEntity = new UserEntity("2", "aa", "bb", "aa@aa.com", list);

		userDao.save(userEntity);
		User user = adminService.findUserByID(userEntity.getId());
		assertThat(user.getId(), is(equalTo(userEntity.getId())));
	}

	@Test
	public void findDish() {
		DishEntity dishEntity = new DishEntity("2", "aa", 11.11, "aa");

		dishDao.save(dishEntity);
		Dish dish = adminService.findDishByID(dishEntity.getId());
		assertThat(dish.getId(), is(equalTo(dishEntity.getId())));
	}

	@Test
	public void getUsers() {

		LinkedList<OrderEntity> list = new LinkedList<>();
		UserEntity userEntity = new UserEntity("1", "login", "haslo", "aa@gmail.com", list);
		userDao.save(userEntity);
		List<User> users = adminService.getListOfUsers();
		List<User> usersExpected = new LinkedList<>();

		LinkedList<Order> list2 = new LinkedList<>();
		User user = new User("1", "login", "haslo", "aa@gmail.com", list2);
		usersExpected.add(user);
		assertThat(users, is(equalTo(usersExpected)));
	}

	@Test
	public void getOrders() {

		OrderEntity oe = new OrderEntity();
		orderDao.save(oe);

		List<Order> orders = adminService.getListOfOrders();
		Order order = new Order();
		LinkedList<Order> expectedOrders = new LinkedList<>();
		expectedOrders.add(order);
		assertThat(orders, is(equalTo(expectedOrders)));

	}

	@Test
	public void getDishes() {
		DishEntity dishEntity = new DishEntity("1", "login", 11.11, "haslo");
		dishDao.save(dishEntity);
		List<Dish> dishes = adminService.getListOfDishes();
		List<Dish> dishesExpected = new LinkedList<>();

		Dish dish = new Dish("1", "login", "haslo", 11.11);
		dishesExpected.add(dish);
		assertThat(dishes, is(equalTo(dishesExpected)));
	}

}
