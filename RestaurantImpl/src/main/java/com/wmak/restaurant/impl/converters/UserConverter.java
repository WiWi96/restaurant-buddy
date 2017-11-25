package com.wmak.restaurant.impl.converters;

import com.wmak.restaurant.impl.entity.UserEntity;

import io.swagger.model.User;

public interface UserConverter {

	public User entityToModelConverter(UserEntity userEntity);
	
	public UserEntity modelToEntityConverter(User user);
}
