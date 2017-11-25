package com.wmak.restaurant.impl.permisionchecker;

import org.springframework.beans.factory.annotation.Autowired;

import com.wmak.restaurant.impl.entity.OrderEntity;
import com.wmak.restaurant.impl.entity.UserEntity;
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
		OrderEntity orderEntity = orderDao.findOne(orderId);
		UserEntity userEntity = userDao.findOne(userId);
		int positionOfOrder = userEntity.getOrdersOfUser().indexOf(orderEntity);
		if (userEntity.getOrdersOfUser().get(positionOfOrder).equals(orderEntity)) {
			return true;
		} else {
				return false;
			}
	}
}
