package com.mycompagny.dao;

import java.util.List;

public interface OrderDao<Order> {
	
	List<Order>getOrders();
	Order addOrder (Order order);
	void deleteOrder(int id);
	Order getOrderById(int id);

}

