package com.wmak.restaurant.impl.converters;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.wmak.restaurant.impl.entity.DishEntity;
import com.wmak.restaurant.impl.entity.OrderEntity;

import io.swagger.model.Dish;
import io.swagger.model.Order;

public class OrderConverterImpl implements OrderConverter {

	@Autowired
	private DishConverter dishConverter;

	@Override
	public Order entityToModelConverter(OrderEntity orderEntity) {
		List<Dish> listOfDishes = orderEntity.getListOfDishes().stream()
															   .map(dishEntity -> dishConverter.entityToModelConverter(dishEntity))
															   .collect(Collectors.toList());
		Order order = new Order(orderEntity.getId(),
								orderEntity.getTableId(),
								listOfDishes);
		return order;
	}

	@Override
	public OrderEntity modelToEntityConverter(Order order) {
		List<DishEntity> listOfDishes = order.getListOfDishes().stream()
															   .map(dish -> dishConverter.modelToEntityConverter(dish))
															   .collect(Collectors.toList());
		OrderEntity orderEntity = new OrderEntity(order.getId(), 
								order.getTableId(),
								listOfDishes);
		return orderEntity;
	}

}
