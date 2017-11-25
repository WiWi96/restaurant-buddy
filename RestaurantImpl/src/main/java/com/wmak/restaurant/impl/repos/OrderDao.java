package com.wmak.restaurant.impl.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wmak.restaurant.impl.entity.Order;

public interface OrderDao extends JpaRepository<Order, String> {

}
