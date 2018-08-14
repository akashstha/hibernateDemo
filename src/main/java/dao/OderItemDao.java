package dao;

import javax.transaction.SystemException;


import pojo.OrderItems;

public interface OderItemDao {
	

		public void createOrderItems(OrderItems items);

		public OrderItems findOrderItem(int id);

		public void updateOrderItems(OrderItems items) throws IllegalStateException, SystemException;

		public boolean deleteOrderItems(int id) throws IllegalStateException, SystemException;
	}

