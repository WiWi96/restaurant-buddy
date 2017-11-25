package com.wmak.restaurant.impl;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.wmak.restaurant.impl.converters.UserConverterImpl;
import com.wmak.restaurant.impl.repos.UserDao;
import com.wmak.restaurant.impl.user.service.UserService;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class UserServiceTest {

	@Autowired
	private UserDao userDao;
	private UserConverterImpl userConverter;
	private UserService userService;

    
	
}
