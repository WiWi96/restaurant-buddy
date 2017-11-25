package com.wmak.restaurant.impl.converters;

import com.wmak.restaurant.impl.entity.DishEntity;

import io.swagger.model.Dish;

public class DishConverterImpl implements DishConverter {

	@Override
	public Dish entityToModelConverter(DishEntity dishEntity) {
		Dish dish = new Dish(dishEntity.getId(),
							dishEntity.getName(),
							dishEntity.getCategory(),
							dishEntity.getPrice());
		return dish;
	}

	@Override
	public DishEntity modelToEntityConverter(Dish dish) {
		DishEntity dishEntity = new DishEntity(dish.getId(),
											   dish.getName(),
											   dish.getPrice(),
											   dish.getCategory());
		return dishEntity;
	}

}
