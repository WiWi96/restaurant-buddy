package com.wmak.restaurant.impl.converters;

import com.wmak.restaurant.impl.entity.OrderEntity;

import io.swagger.model.Order;

public interface OrderConverter {

	public Order entityToModelConverter(OrderEntity orderEntity);
	
	public OrderEntity modelToEntityConverter(Order order);
}
