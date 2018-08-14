package dao;

import javax.transaction.SystemException;

import pojo.Customer;

public interface CustomerDao {
	public void createCustomer(Customer customer);
	public Customer findCustomer(int id);
	public void updateCustomer(Customer customer) throws IllegalStateException, SystemException;
	public boolean deleteCustomer(int id) throws IllegalStateException, SystemException;
	
	

}
