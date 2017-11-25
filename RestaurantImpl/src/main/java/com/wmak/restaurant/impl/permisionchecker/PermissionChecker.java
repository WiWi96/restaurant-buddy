package com.wmak.restaurant.impl.permisionchecker;

import org.springframework.beans.factory.annotation.Autowired;

import com.wmak.restaurant.impl.entity.Order;
import com.wmak.restaurant.impl.entity.User;
import com.wmak.restaurant.impl.repos.OrderDao;
import com.wmak.restaurant.impl.repos.UserDao;

public class PermissionChecker implements PermissionCheckerInterface {
	
	private UserDao userDao;
	private OrderDao orderDao;
	
	@Autowired
	public PermissionChecker(UserDao userDao, OrderDao orderDao) {
		super();
		this.userDao = userDao;
		this.orderDao = orderDao;
	}

	public boolean checker(String userId, String orderId) {
		Order orderEntity = orderDao.findOne(orderId);
		User userEntity = userDao.findOne(userId);
//		int positionOfOrder = userEntity.getOrdersOfUser().indexOf(orderEntity);
//		if (userEntity.getOrdersOfUser().get(positionOfOrder).equals(orderEntity)) {
			return true;
//		} else {
//				return false;
//			}
	}
}
