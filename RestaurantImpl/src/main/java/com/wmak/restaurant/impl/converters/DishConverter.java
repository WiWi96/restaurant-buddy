package com.wmak.restaurant.impl.converters;

import com.wmak.restaurant.impl.entity.DishEntity;
import io.swagger.model.Dish;

public interface DishConverter {
	
	public Dish entityToModelConverter(DishEntity dishEntity);
	
	public DishEntity modelToEntityConverter(Dish dish);
}
	
