package com.wmak.restaurant.impl.admin.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wmak.restaurant.impl.entity.DishEntity;
import com.wmak.restaurant.impl.entity.UserEntity;
import com.wmak.restaurant.impl.repos.UserDao;

public class AdminService implements AdminServiceInterface {

	@Autowired
	private UserDao userDao;
	private List<UserEntity> listOfUsers;
	private List<DishEntity> listOfDishes;

	@Override
	public boolean addNewUser(String id, String username, String password) {

		UserEntity newUser = new UserEntity(id, username, password);

		for (UserEntity ue : listOfUsers) {
			if (ue.getId().equals(id)) {
				System.out.println("In the database is just user with id: " + id);
				return false;
			}

			if (ue.getUsername().equals(username)) {
				System.out.println("In the database is just user with login: " + username);
				return false;
			}
		}
		if (listOfUsers.add(newUser))
			return true;

		return false;
	}

	@Override
	public boolean deleteUser(String id) {

		for (UserEntity ue : listOfUsers)
			if (ue.getId().equals(id))
				if (listOfUsers.remove(ue))
					return true;
		userDao.

		return false;
	}

	@Override
	public boolean modifyUser(String id, String newUsername) {

		for (UserEntity ue : listOfUsers)
			if (ue.getId().equals(id)) {
				ue.setUsername(newUsername);
				return true;
			}
		return false;
	}

	@Override
	public boolean addNewDishToMenu(String id, String name, double price, String category) {

		DishEntity newDish = new DishEntity(id, name, price, category);

		for (DishEntity ue : listOfDishes) {
			if (ue.getId().equals(id)) {
				System.out.println("In the database is just dish with id: " + id);
				return false;
			}

			if (ue.getName().equals(name)) {
				System.out.println("In the database is just dish with login: " + name);
				return false;
			}
		}
		if (listOfDishes.add(newDish))
			return true;

		return false;
	}

	@Override
	public boolean deleteDishFromMenu(String id) {

		for (DishEntity ue : listOfDishes)
			if (ue.getId().equals(id))
				if (listOfDishes.remove(ue))
					return true;

		return false;
	}

	@Override
	public boolean modifyDish(String id, String newName, double newPrice) {
		for (DishEntity ue : listOfDishes)
			if (ue.getId().equals(id)) {
				ue.setName(newName);
				ue.setPrice(newPrice);
				return true;
			}
		return false;
	}

	@Override
	public boolean modifyDish(String id, double price) {
		for (DishEntity ue : listOfDishes)
			if (ue.getId().equals(id)) {
				ue.setName(newName);
				ue.setPrice(newPrice);
				return true;
			}
		return false;
	}

	@Override
	public boolean modifyDish(String id, String newName) {
		for (DishEntity ue : listOfDishes)
			if (ue.getId().equals(id)) {
				ue.setName(newName);
				ue.setPrice(newPrice);
				return true;
			}
		return false;
	}

	@Override
	public boolean findDishByID(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean findUserByID(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List getListOfUsers() {
		return this.listOfUsers;
	}

	@Override
	public List getListOfDishes() {
		return this.listOfDishes;
	}

	@Override
	public List getListOfDishesByCategory(String category) {
		LinkedList<DishEntity> categorizedList = new LinkedList<>();
		for (DishEntity de : listOfDishes) {
			if (category.equals(de.getCategory()))
				categorizedList.add(de);
		}
		return categorizedList;
	}

}
