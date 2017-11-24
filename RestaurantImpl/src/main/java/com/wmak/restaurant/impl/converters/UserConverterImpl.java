package com.wmak.restaurant.impl.converters;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.wmak.restaurant.impl.entity.OrderEntity;
import com.wmak.restaurant.impl.entity.UserEntity;

import io.swagger.model.Dish;
import io.swagger.model.Order;
import io.swagger.model.User;

public class UserConverterImpl implements UserConverter {

	@Autowired
	private OrderConverter orderConverter;

	@Override
	public User entityToModelConverter(UserEntity userEntity) {
		List<Order> listOfOrders = userEntity.getOrdersOfUser().stream()
				   											   .map(orderEntity -> orderConverter.entityToModelConverter(orderEntity))
				   											   .collect(Collectors.toList());
		User user = new User(userEntity.getId(),
							 userEntity.getUsername(),
							 userEntity.getPassword(),
							 userEntity.getEmail(),
							 listOfOrders);
		return user;
	}

	@Override
	public UserEntity modelToEntityConverter(User user) {
		List<OrderEntity> listOfOrders = user.getListOfOrders().stream()
				   											   .map(order -> orderConverter.modelToEntityConverter(order))
				   											   .collect(Collectors.toList());
		UserEntity userEntity = new UserEntity(user.getId(),
							 				   user.getUsername(),
							 				   user.getPassword(),
							 				   user.getEmail(),
							 				   listOfOrders);
		return userEntity;
	}
}
