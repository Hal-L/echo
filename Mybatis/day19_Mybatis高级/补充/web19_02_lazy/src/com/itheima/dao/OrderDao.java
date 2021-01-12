package com.itheima.dao;


import com.itheima.domain.Order;
import com.itheima.domain.User;

public interface OrderDao {

    Order findOrderByUserId(Integer id);
}
