package com.wmak.restaurant.impl.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.wmak.restaurant.impl.repos.UserDao;

@Service
public class UserServiceImpl implements UserDetailsService {
	
	private UserDao userDao;
	@Autowired
	public UserServiceImpl(UserDao userDao) { 
		this.userDao = userDao;
	}
	/**
	 * Check if user is in database
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userDao.findByUsername(username);
		if(user==null) {
			throw new UsernameNotFoundException(username);
		}
		return new UserDatailsImpl(user);
	}

}
