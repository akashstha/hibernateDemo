package dao;

import javax.transaction.SystemException;

import pojo.Orders;

public interface Oders {

	public void createOrder(Orders orders);
	
	public Orders findOrder(int id);

	public void updateOrder(Orders orders) throws IllegalStateException, SystemException;

	public boolean deleteOrder(int id) throws IllegalStateException, SystemException;

}
